package com.day.day.up.main.testApplication.dto;

import lombok.Data;

/**
 * 支付渠道信息dto
 *
 * @author wf
 */
@Data
public class PayChannelInfoDto extends BaseDTO {

    private static final long serialVersionUID = 2987076603354158184L;

    /**
     * 支付渠道编码
     */
    private String payChannel;

    /**
     * 支付渠道名称
     */
    private String payChannelName;

    /**
     * 支付渠道状态：0-停用 1-启用
     */
    private Integer status;

    /**
     * 其他类型
     */
    private PayChannelOtherDto payChannelOtherDto;

}