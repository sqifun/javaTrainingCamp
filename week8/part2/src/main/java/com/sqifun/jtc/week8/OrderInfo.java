package com.sqifun.jtc.week8;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @program: week5-part10
 * @className: Person
 * @description:
 * @author: sqi
 * @date: 2022-02-13 21:31
 * @version: 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderInfo {

   private Long id;
   private Long number;
   private Long userId;
   private Long userAddressId;
   private Long productId;
   private Integer paymentMethod;
   private Double originMoney;
   private Double districtMoney;
   private Double expressMoney;
   private Double paymentMoney;
   private String expressCompany;
   private Long expressNumber;
   private Date payTime;
   private Date sendTime;
   private Date receiveTime;
   private Integer status;
   private Date createTime;
   private Date updateTime;
   private Integer isValid;
   private String remark;

}