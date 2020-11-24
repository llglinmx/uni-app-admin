package com.doufu.words.Controller;


import com.doufu.words.Controller.DTO.UserParameter;
import com.doufu.words.Model.vo.Result;
import com.doufu.words.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin() // 解决跨域访问
@RequestMapping(value = "user")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /*
    * 用户信息
    * */
    @RequestMapping(value = "userInfo")
    public Result userInfo(UserParameter userParameter){
        return userService.userInfo(userParameter);
    }

}
