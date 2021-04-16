package com.day.day.up.main.testApplication.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付商户支付产品实体类
 *
 * @author wf
 */
@Data
public class PayProductMerMappingDTO implements Serializable {

    private static final long serialVersionUID = -770729302879078432L;

    private String payProduct;

    private String cardType;

    private String bankCode;

    private String isSupportRefund;

    private String isSupportShare;

}
