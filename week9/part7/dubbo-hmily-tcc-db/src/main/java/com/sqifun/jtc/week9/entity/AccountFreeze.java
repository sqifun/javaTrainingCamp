package com.sqifun.jtc.week9.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @program: week9-part7
 * @className: AccountFreeze
 * @description:
 * @author: sqi
 * @date: 2022-03-13 17:05
 * @version: 1.0
 **/
@Data
@Accessors(chain = true)
@TableName(value = "account_freeze", autoResultMap = true)
public class AccountFreeze {

    private Long id;

    private String userName;

    private Double balance;

    private Date createTime;

    private Date updateTime;

}