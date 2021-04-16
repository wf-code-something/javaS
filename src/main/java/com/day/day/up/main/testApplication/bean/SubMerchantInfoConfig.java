package com.day.day.up.main.testApplication.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SubMerchantInfoConfig {
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 支付渠道名称 eg:SUB_PROTOCOL_BAOFOO
     */
    private String payChannel;
    /**
     * 支付渠道商户号 eg:1236252
     */
    private String payMerchantNo;
    /**
     * 支付渠道商户名称 eg:中腾信金融信息服务（上海）有限公司
     */
    private String payMerchantName;
    /**
     * 分账方商户号 eg:1236252
     */
    private String subMerchantNo;
    /**
     * 分账方商户名称 eg:中腾信金融信息服务（上海）有限公司
     */
    private String subMerchantName;
    /**
     * 分账方简称 eg:ZTX
     */
    private String subMerchant;
    /**
     * 状态 1有效 0 无效
     */
    private boolean isAvailable;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 更新人
     */
    private String updateBy;

    public SubMerchantInfoConfig(){

    }

    public SubMerchantInfoConfig(String subMerchantNo){
        this.subMerchantNo = subMerchantNo;
    }
    public SubMerchantInfoConfig(Long id, String payChannel, String payMerchantNo, String payMerchantName, String subMerchantNo, String subMerchantName, String subMerchant, boolean isAvailable, Date createTime, Date updateTime, String createBy, String updateBy) {
        this.id = id;
        this.payChannel = payChannel;
        this.payMerchantNo = payMerchantNo;
        this.payMerchantName = payMerchantName;
        this.subMerchantNo = subMerchantNo;
        this.subMerchantName = subMerchantName;
        this.subMerchant = subMerchant;
        this.isAvailable = isAvailable;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.createBy = createBy;
        this.updateBy = updateBy;
    }
}
