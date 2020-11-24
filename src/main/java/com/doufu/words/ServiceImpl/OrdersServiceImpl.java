package com.doufu.words.ServiceImpl;

import com.doufu.words.Controller.DTO.OrderParameter;
import com.doufu.words.Dao.OrdersRepository;
import com.doufu.words.Dao.UserRepository;
import com.doufu.words.Dao.VipTypeRepository;
import com.doufu.words.Domain.Orders;
import com.doufu.words.Domain.User;
import com.doufu.words.Domain.VipType;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.OrdersService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private UserRepository userRepository;
    @Resource
    private OrdersRepository ordersRepository;
    @Resource
    private VipTypeRepository vipTypeRepository;

    @Override
    public Result createOrder(OrderParameter orderParameter) {
        if (orderParameter.getUserId() == null) {
            return Result.createFail("请传递用户id");
        }
        if (orderParameter.getId() == null) {
            return Result.createFail("请传递兑换类型id");
        }

        User user = userRepository.findByUserId(orderParameter.getUserId()); // 获取用户信息
        VipType vipType = vipTypeRepository.findAllById(orderParameter.getId());// 获取会员类型信息

        // 生成订单号
        SimpleDateFormat format = new SimpleDateFormat("yyMMddhhmmss");
        Date today = new Date();
        String orderNumber = format.format(today);
        // 生成订单id
        SimpleDateFormat numbers = new SimpleDateFormat("hhmmss");
        Random random = new Random();
        int ran1 = random.nextInt(8);
        Integer orderId = Integer.parseInt("" + ran1 + 1 + "" + numbers.format(new Date()));

        Orders orders = new Orders();
        Calendar now = Calendar.getInstance();
        now.add(Calendar.DAY_OF_WEEK, vipType.getVipDay()); //过期天数

        Date state = new Date();
        Date end = user.getVipExpireTime();

        //  写入数据进数据库
        orders.setOrderId(orderId);
        orders.setUserId(user.getUserId());
        orders.setUserName(user.getUserName());
        orders.setPhone(user.getPhone());
        orders.setBuyType(vipType.getTypeTitle());
        orders.setOrderMoney(vipType.getTypeMoney());
        orders.setOrderNumber(orderNumber);
        orders.setOrderCreateTime(new Date());
        ordersRepository.save(orders);//添加数据 创建订单

        if(end!=null){ // end 如果等于null 代表第一次开通会员
            if(state.before(end)){  //当前时间是否大于过期时间  大于 false  小于true
                now.setTime(user.getVipExpireTime()); // 重新设置过期天数  在原本过期的天数基础上增加需要增加的天数
            }
            user.setVipUpdateTime(new Date());
        }else {
            user.setVipCreateTime(new Date());//vip 创建时间
        }
        now.add(Calendar.DAY_OF_WEEK, vipType.getVipDay()); //过期天数
        user.setVipExpireTime(now.getTime()); //vip 过期时间
        user.setIsVip(1);
        userRepository.save(user); // 更新用户数据

        return Result.createSuccess("订单创建成功", orderNumber);
    }
}
