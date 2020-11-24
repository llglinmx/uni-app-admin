package com.doufu.words.Controller;

import com.doufu.words.Controller.DTO.IntegralParameter;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.IntegralExchangeListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin() // 解决跨域访问
@RequestMapping(value = "integral")
@RestController
public class IntegralController {


    @Autowired
    private IntegralExchangeListService integralExchangeListService;

    /*
    * 获取积分兑换列表
    * */
    @RequestMapping(value = "getExchangeList")
    public Result getExchangeList(IntegralParameter integralParameter){
        return integralExchangeListService.getExchangeList(integralParameter);
    }

    /*
    * 积分兑换vip
    * */
    @RequestMapping(value = "exchangeVip")
   public Result exchangeVip(IntegralParameter integralParameter){
        return integralExchangeListService.exchangeVip(integralParameter);
   }
}

