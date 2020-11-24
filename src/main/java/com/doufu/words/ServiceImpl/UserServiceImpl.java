package com.doufu.words.ServiceImpl;

import com.doufu.words.Controller.DTO.UserParameter;
import com.doufu.words.Dao.UserRepository;
import com.doufu.words.Domain.User;
import com.doufu.words.Model.retrunType.UserInfo;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public Result userInfo(UserParameter userParameter) {

        if (userParameter.getUserId() == null) {
            return Result.createFail("请传递用户id");
        }
        User userList = userRepository.findByUserId(userParameter.getUserId()); //根据用户id获取积分

        Date state = new Date();
        Date end = userList.getVipExpireTime();

        UserInfo userInfo = new UserInfo();

        userInfo.setUserId(userList.getUserId());
        userInfo.setUserName(userList.getUserName());
        userInfo.setPhone(userList.getPhone());
        userInfo.setUserIntegral(userList.getUserIntegral());

        Boolean bool = false;
        if (end!=null){
            bool = state.before(end) ? true : false;// 判断当前时间是否大于过期时间   true则代表会员未过期  false已过期  state.before(end)
        }

        userInfo.setIsVip(bool);

        //转化日期为正常 显示
        Date date = userList.getVipExpireTime();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String[] arr =null;
        if(bool){//为会员则返回到期时间  否则null
            arr =  sdf.format(date).split(" "); // 以空格切割 单独返回日期
            userInfo.setVipExpireTime(arr[0]);
        }else{
            userInfo.setVipExpireTime(null);
        }

        return Result.createSuccess("数据获取成功", userInfo);
    }
}
