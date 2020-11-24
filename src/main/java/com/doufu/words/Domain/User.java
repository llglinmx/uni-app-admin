package com.doufu.words.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", columnDefinition = "Integer COMMENT '用户id'")
    private Integer userId;// 用户id

    @Column(name = "user_name", columnDefinition = "char(10) COMMENT '用户名'")
    private String userName;//用户名

    @Column(name = "user_image", columnDefinition = "varchar(255) COMMENT '用户头像'")
    private String userImage;//用户头像

    @Column(name = "phone", columnDefinition = "char(11) COMMENT '用户手机号'")
    private String phone;// 用户手机号

    @Column(name = "password", columnDefinition = "varchar(255) COMMENT '用户密码'")
    private String password;// 密码

    @Column(name = "user_integral", columnDefinition = "Integer COMMENT '用户积分'")
    private Integer userIntegral;//用户积分

    @Column(name = "is_vip", columnDefinition = "Integer COMMENT '是否会员 0 不是会员 1 为会员'")
    private Integer isVip;//是否会员

    @Column(name = "vip_create_time", columnDefinition = "DATETIME COMMENT '会员开通时间'")
    private Date vipCreateTime;// 会员开通时间

    @Column(name = "vip_update_time", columnDefinition = "DATETIME COMMENT '会员更新时间'")
    private Date vipUpdateTime;// 会员更新时间

    @Column(name = "vip_expire_time", columnDefinition = "DATETIME COMMENT '会员到期时间'")
    private Date vipExpireTime;// 会员到期时间

    @Column(name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
    private Date createTime;// 创建时间

    @Column(name = "update_time", columnDefinition = "DATETIME COMMENT '更新时间'")
    private Date updateTime;// 更新时间

}
