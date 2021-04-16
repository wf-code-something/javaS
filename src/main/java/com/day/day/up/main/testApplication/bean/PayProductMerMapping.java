package com.day.day.up.main.testApplication.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付渠道产品商户映射model
 *
 * @author wf
 */
@Data
public class PayProductMerMapping implements Serializable{

    private static final long serialVersionUID = -6790235349814547945L;

    private Long id;

    /**
     * 支付渠道商户主键ID
     */
    private Long payChannelMerId;

    /**
     * 支付产品
     */
    private String payProduct;

    /**
     * 支持卡类型
     */
    private String cardType;

    /**
     * 支持银行卡编号
     */
    private String bankCode;

    /**
     * 是否支持分账 0不支持 1 支持
     */
    private String isSupportShare;

    /**
     * 是否支持退款 0不支持 1 支持
     */
    private String isSupportRefund;

    private boolean flag;

}