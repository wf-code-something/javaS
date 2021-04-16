package com.day.day.up.main.testApplication.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author admin
 */
@Data
public class PayChannelOtherDto implements Serializable {

    private PayChannelInnerDto dto;

    private String otherThing;


}
