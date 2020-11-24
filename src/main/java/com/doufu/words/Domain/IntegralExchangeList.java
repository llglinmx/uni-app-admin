package com.doufu.words.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class IntegralExchangeList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "Integer COMMENT '积分兑换列表id'")
    private  Integer id;

    @Column(name = "day", columnDefinition = "Integer(4) COMMENT '积分兑换天数'")
    private  Integer day;

    @Column(name = "integral_number", columnDefinition = "Integer(4) COMMENT '积分兑换天数'")
    private  Integer integralNumber;

    @Column(name = "create_time", columnDefinition = "DATETIME COMMENT '创建时间'")
    private Date createTime;// 创建时间

    @Column(name = "update_time", columnDefinition = "DATETIME COMMENT '更新时间'")
    private Date updateTime;// 更新时间
}
