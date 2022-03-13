package com.sqifun.jtc.week9.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;


/**
 * @program: week9-part7
 * @className: AccountRmb
 * @description:
 * @author: sqi
 * @date: 2022-03-13 17:05
 * @version: 1.0
 **/
@Data
@Accessors(chain = true)
@TableName(value = "account_rmb", autoResultMap = true)
public class AccountRmb {

    private Long id;

    private String userName;

    private Double balance;

    private Date createTime;

    private Date updateTime;

}