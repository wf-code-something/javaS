package com.day.day.up.main.guavalimit.aop;

import com.day.day.up.main.guavalimit.annotation.PayRateLimit;
import com.day.day.up.main.guavalimit.exception.PayLimitAccessException;
import com.day.day.up.main.guavalimit.util.PayRateLimitUtil;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * aop 需要定义切点 Pointcut（可以指定切面方法，或者指定切面注解）
 *
 */
@Slf4j
@Aspect
@Component
public class PayRateLimitAspect {

    /**
     * 缓存
     * maximumSize 设置缓存个数
     * expireAfterWrite 写入后过期时间
     */
    private static LoadingCache<String, RateLimiter> limitCaches = CacheBuilder.newBuilder()
            .maximumSize(1000)
            .expireAfterWrite(1, TimeUnit.DAYS)
            .build(new CacheLoader<String, RateLimiter>() {
                @Override
                public RateLimiter load(String key) throws Exception {
                    double perSecond = PayRateLimitUtil.getCacheKeyPerSecond(key);
                    return RateLimiter.create(perSecond);
                }
            });
    /**
     * 切点
     * 通过扫包切入 @Pointcut("execution(public * com.ycn.springcloud..*.*(..))")
     * 带有指定注解切入 @Pointcut("@annotation(com.ycn.springcloud.annotation.LxRateLimit)")
     */
    @Pointcut("@annotation(com.day.day.up.main.guavalimit.annotation.PayRateLimit)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        log.info("限流拦截到了{}方法...", point.getSignature().getName());
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        if (method.isAnnotationPresent(PayRateLimit.class)) {
            String cacheKey = PayRateLimitUtil.generateCacheKey(method, request);
            RateLimiter limiter = limitCaches.get(cacheKey);
            if (!limiter.tryAcquire()) {
                throw new PayLimitAccessException("【限流】这位小同志的手速太快了");
            }
        }
        Object object = point.proceed();
        log.info("object is {}", object);
        if (object != null && object instanceof String) {
            object = "inner" + object;
        }
        log.info("object is {}", object);
        return object;
    }

}
