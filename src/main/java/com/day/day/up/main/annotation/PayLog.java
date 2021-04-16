package com.day.day.up.main.annotation;

import com.day.day.up.main.enums.CommonEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * 日志注解,建议放在service层，使用上的时候看执行的操作去赋予moduleName、param、operatorType、clazz(对应service层注入的mapper.class)就可以了
 *
 * @author wf
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PayLog {

    /**
     * module枚举，自定义的操作枚举 默认DEMO_ADD
     */
    CommonEnum.BizModuleEnum moduleName() default CommonEnum.BizModuleEnum.DEMO_ADD;

    /**
     * 更新、删除的时候需要赋值,传入对应service注入的mapper
     * 新增不需要赋值
     */
    Class clazz() default Void.class;

    /**
     * 更新、删除的时候需要赋值，默认selectByPrimaryKey
     * 新增不需要赋值
     */
    String method() default "selectByPrimaryKey";

    /**
     * 更新、删除的时候,需要传入的属性 ${model.property}或者 ${property} 或者常量1,2,3(虽然支持，但是现在应该也不会用这种的配置)
     * 新增不需要赋值
     */
    String param() default "";

    /**
     * 操作类型 默认ADD
     * 如果是新增操作，可以不添加该值
     * 更新和修改需要赋值
     * 是按照OperatorType进行逻辑区分操作
     */
    CommonEnum.OperatorType operatorType() default CommonEnum.OperatorType.ADD;

    /**
     * 是否要存入db，可以根据该参数是否要做存入db的操作，默认true
     */
    boolean dbFlag() default true;

}
