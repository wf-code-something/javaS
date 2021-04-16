package com.day.day.up.main.guavalimit.annotation;

import com.day.day.up.main.guavalimit.enums.LimitKeyTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author admin
 */
@Target(ElementType.METHOD)//作用在方法上
@Retention(RetentionPolicy.RUNTIME)//运行中
public @interface PayRateLimit {

    String name() default "默认资源";

    double perSecond() default 3;

    LimitKeyTypeEnum limitKeyType() default LimitKeyTypeEnum.IPADDR;
}
