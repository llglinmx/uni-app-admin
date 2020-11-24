package com.doufu.words.ServiceImpl;

import com.doufu.words.Controller.DTO.IntegralParameter;
import com.doufu.words.Dao.IntegralExchangeListRepository;
import com.doufu.words.Dao.UserRepository;
import com.doufu.words.Domain.IntegralExchangeList;
import com.doufu.words.Domain.User;
import com.doufu.words.Model.retrunType.ExchangeData;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.IntegralExchangeListService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@Service
public class IntegralExchangeListServiceImpl implements IntegralExchangeListService {
    @Resource
    private IntegralExchangeListRepository integralExchangeListRepository;
    @Resource
    private UserRepository userRepository;

    @Override
    public Result getExchangeList(IntegralParameter integralParameter) {
        if (integralParameter.getUserId() == null) {
            return Result.createFail("请传递用户id");
        }
        User user = userRepository.findByUserId(integralParameter.getUserId()); //根据用户id获取积分

        List<IntegralExchangeList> integralExchangeLists = integralExchangeListRepository.findAll();

        ExchangeData exchangeData = new ExchangeData();
        exchangeData.setIntegeral(user.getUserIntegral());
        exchangeData.setData(integralExchangeLists);

        return Result.createSuccess("数据获取成功", exchangeData);

    }

    @Override
    public Result exchangeVip(IntegralParameter integralParameter) {
        if (integralParameter.getUserId() == null) {
            return Result.createFail("请传递用户id");
        }
        if (integralParameter.getIntegralId() == null) {
            return Result.createFail("请传递所需兑换列表积分id");
        }
        User userInfo = userRepository.findByUserId(integralParameter.getUserId()); //根据用户id获取积分数量
        IntegralExchangeList integralExchangeList = integralExchangeListRepository.findAllById(integralParameter.getIntegralId());//根据积分id 获取所需兑换积分数量
        if (integralExchangeList.getIntegralNumber() > userInfo.getUserIntegral()) {
            return Result.createFail("兑换失败,积分数量不足");
        }

        Integer integralNum = userInfo.getUserIntegral() - integralExchangeList.getIntegralNumber(); // 兑换之后剩余积分
        Calendar now = Calendar.getInstance();
        //判断是否第一次开通会员
        if(userInfo.getVipExpireTime()==null){
            now.add(Calendar.DAY_OF_WEEK, integralExchangeList.getDay()); //过期天数
            userInfo.setVipCreateTime(new Date());//vip 创建时间
        }else{
            Date state = new Date();
            Date end = userInfo.getVipExpireTime();
            // 判断当前时间是否大于过期时间   true则代表会员未过期  false已过期
            if(state.before(end)){
                now.setTime(userInfo.getVipExpireTime());
                now.add(Calendar.DAY_OF_WEEK, integralExchangeList.getDay()); //过期天数
                userInfo.setVipUpdateTime(new Date());//vip 更新时间
            }else{
                now.add(Calendar.DAY_OF_WEEK, integralExchangeList.getDay()); //过期天数
                userInfo.setVipUpdateTime(new Date());//vip 更新时间
            }
        }

        userInfo.setVipExpireTime(now.getTime()); //vip 过期时间
        userInfo.setIsVip(1);
        userInfo.setUserIntegral(integralNum);

        userRepository.save(userInfo);// 更新数据

        return Result.createSuccess("积分兑换成功", true);
    }


}
