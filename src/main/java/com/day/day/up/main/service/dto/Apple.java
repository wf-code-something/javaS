package com.day.day.up.main.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author admin
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class Apple implements Serializable {

    private long id;

    private int size;

    private String color;

}
