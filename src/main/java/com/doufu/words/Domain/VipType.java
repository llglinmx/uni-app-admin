package com.doufu.words.Domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class VipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "Integer COMMENT 'id'")
    private Integer id;

    @Column(name = "type_title", columnDefinition = "char(10) COMMENT 'vip类型标题'")
    private String typeTitle;//vip类型标题

    @Column(name = "type_money", columnDefinition = "double COMMENT 'vip类型购买金额'")
    private Double typeMoney;// vip类型金额

    @Column(name = "vip_day", columnDefinition = "double COMMENT 'vip购买天数'")
    private Integer vipDay;// vip类型金额
}
