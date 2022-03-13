package com.sqifun.jtc.week9.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @program: week9-part7
 * @className: AccountDollar
 * @description:
 * @author: sqi
 * @date: 2022-03-13 17:00
 * @version: 1.0
 **/
@Data
@Accessors(chain = true)
@TableName(value = "account_dollar", autoResultMap = true)
public class AccountDollar {

    private Long id;

    private String userName;

    private Double balance;

    private Date createTime;

    private Date updateTime;

}