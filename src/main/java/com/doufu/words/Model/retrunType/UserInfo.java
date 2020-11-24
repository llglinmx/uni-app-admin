package com.doufu.words.Model.retrunType;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class UserInfo {

    private Integer userId;// 用户id

    private String userName;//用户名

    private String phone;// 用户手机号

    private Integer userIntegral;//用户积分

    private Boolean isVip;//是否会员

    private String vipExpireTime;// 会员到期时间
}
