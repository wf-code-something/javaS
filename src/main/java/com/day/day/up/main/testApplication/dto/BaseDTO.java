package com.day.day.up.main.testApplication.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 补充baseDto
 *
 * @author wf
 */
@Data
public class BaseDTO implements Serializable {

    private static final long serialVersionUID = -3250521079810444553L;

    /**
     * 主键Id
     */
    private Long id;
    /**
     * 创建人
     */
    private String createBy;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 更新时间
     */
    private Date updateTime;
    /**
     * 备注
     */
    private String remark;

}
