package com.day.day.up.main.testApplication;

import com.day.day.up.main.testApplication.dto.PayChannelInfoDto;
import com.day.day.up.main.testApplication.dto.PayChannelInnerDto;
import com.day.day.up.main.testApplication.dto.PayChannelOtherDto;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

@Slf4j
public class Test {

    private static final String IS_MATCH_STR = "\\$\\{\\D*\\}";

    /**
     * String.contains()方法的入参类型是CharSequence，可以不用转义
     */
    private static final String CONTAINS_COMPLEX_PATTER = ".";

    /**
     * String.split()方法的入参类型是String，按情况需要转义
     */
    private static final String SPLIT_COMPLEX_PATTER = "\\.";

    /**
     * 字符串解析前缀
     */
    private static final String PARAM_REPLACE_PREFIX_REG = "\\$\\{";

    /**
     * 字符串解析后缀
     */
    private static final String PARAM_REPLACE_SUFFIX_REG = "\\}";

    /**
     * 方法名前缀
     */
    private static final String METHOD_PREFIX_NAME = "get";

    /**
     * 解析注解上的值，利用反射将方法的入参参数的变量映射到我们配置在注解上
     *
     * @param invokeParam 需要解析的字符串 可以写成复杂类型${model.property}或者简单类型${property}，或者固定值 比如1 2 3
     * @return Object
     */
    public static Object resolver(JoinPoint joinPoint, String invokeParam) {

        if (invokeParam == null) {
            return null;
        }
        Object value = null;
        //如果注解上的属性匹配上了${},则把内容当作变量,解析变量
        if (invokeParam.matches(IS_MATCH_STR)) {
            //property eg->model.property
            String property = invokeParam.replaceAll(PARAM_REPLACE_PREFIX_REG, "").replaceAll(PARAM_REPLACE_SUFFIX_REG, "");
            //复杂类型->model.property
            if (property.contains(CONTAINS_COMPLEX_PATTER)) {
                try {
                    value = complexResolver(joinPoint, property);
                } catch (Exception e) {
                    log.info("解析属性异常，请检查配置是否正确，异常原因={}" + e.getMessage(), e);
                }
            } else {
                //简单类型->property
                value = simpleResolver(joinPoint, property);
            }
        } else {
            //常量值
            value = invokeParam;
        }
        return value;
    }

    public static void main(String[] args) throws Exception{
        String invokeParam = "${req.payChannelOtherDto.dto.innerId}";
        String params = "req.payChannelOtherDto.dto.innerId";
        String invokeParam1 = "${req.id}";
        String params1 = "req.id";

        System.out.println(complexResolver(null, params).toString());
        System.out.println(complexResolver(null, params1));

    }


    /**
     * 处理model.property类型
     *
     * @param joinPoint joinPoint
     * @param objectAndProperty eg:model.property
     * @return 根据model.property反射出来的值
     * @throws Exception
     */
    private static Object complexResolver(JoinPoint joinPoint, String objectAndProperty) throws Exception {
        PayChannelInfoDto payChannelInfoDto = new PayChannelInfoDto();
        PayChannelOtherDto payChannelOtherDto = new PayChannelOtherDto();
        PayChannelInnerDto payChannelInnerDto = new PayChannelInnerDto();
        payChannelInnerDto.setInnerId(5L);
        payChannelOtherDto.setDto(payChannelInnerDto);
        payChannelInfoDto.setPayChannelOtherDto(payChannelOtherDto);
        payChannelInfoDto.setId(3L);

        String[] params = objectAndProperty.split(SPLIT_COMPLEX_PATTER);
        //支持父类的属性获取
        Method getMethod = payChannelInfoDto.getClass().getMethod(getMethodName(params[1]));
        getMethod.setAccessible(true);
        Object value = getMethod.invoke(payChannelInfoDto);
        Object value1 = getValue(value ,1, params);
        return value1;
    }

    private static Object getValue(Object obj, int index, String[] params) {
        try {
            if (obj != null && index < params.length - 1) {
                Method method = obj.getClass().getMethod(getMethodName(params[index + 1]));
                obj = method.invoke(obj);
                obj = getValue(obj, index + 1, params);
            }
            return obj;

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取接口的入参对象value
     *
     * @param joinPoint   joinPoint
     * @param invokeParam invokeParam
     * @return 对象value
     */
    public static Object getReallyObject(JoinPoint joinPoint, String invokeParam) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] names = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        if (StringUtils.isEmpty(invokeParam)) {
            return args[0];
        }
        String str = invokeParam.replaceAll(PARAM_REPLACE_PREFIX_REG, "").replaceAll(PARAM_REPLACE_SUFFIX_REG, "");
        //param是要存的属性对象值
        String[] params = str.split(SPLIT_COMPLEX_PATTER);
        for (int i = 0; i < names.length; i++) {
            if (params[0].equals(names[i])) {
                Object obj = args[i];
                return obj;
            }
        }
        return null;
    }

    /**
     * 动态组装get方法名称
     *
     * @param property eg:id
     * @return getMethod
     */
    private static String getMethodName(String property) {
        StringBuilder methodName = new StringBuilder();
        methodName.append(METHOD_PREFIX_NAME);
        methodName.append(property.replaceFirst(property.substring(0, 1), property.substring(0, 1).toUpperCase()));
        return methodName.toString();
    }

    /**
     * 处理简单类型 eg: id
     *
     * @param joinPoint joinPoint
     * @param property 单纯属性
     * @return 简单类型对应的绑定值
     */
    private static Object simpleResolver(JoinPoint joinPoint, String property) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String[] names = methodSignature.getParameterNames();
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < names.length; i++) {
            if (property.equals(names[i])) {
                return args[i];
            }
        }
        return null;
    }


}
