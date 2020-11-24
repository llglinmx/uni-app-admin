package com.doufu.words.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "Integer COMMENT 'id'")
    private Integer id;

    @Column(name = "order_id", columnDefinition = "Integer COMMENT '订单id'")
    private Integer orderId;

    @Column(name = "user_id", columnDefinition = "Integer COMMENT '用户id'")
    private Integer userId;// 用户id

    @Column(name = "user_name", columnDefinition = "char(10) COMMENT '用户名'")
    private String userName;//用户名

    @Column(name = "phone", columnDefinition = "char(11) COMMENT '用户手机号'")
    private String phone;// 用户手机号

    @Column(name = "buy_type", columnDefinition = "char(5) COMMENT '会员购买类型 半年 一年'")
    private String buyType;// 会员购买类型   半年  一年

    @Column(name = "order_money", columnDefinition = "double COMMENT '订单金额'")
    private Double orderMoney;// 订单金额

    @Column(name = "order_number", columnDefinition = "char(20) COMMENT '订单编号'")
    private String orderNumber;

    @Column(name = "order_create_time", columnDefinition = "DATETIME COMMENT '订单创建时间'")
    private Date orderCreateTime;// 订单创建时间
}
