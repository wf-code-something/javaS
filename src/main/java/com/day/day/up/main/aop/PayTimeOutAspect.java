package com.day.day.up.main.aop;

import com.day.day.up.main.annotation.TimeOut;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.*;

@Aspect
@Slf4j
@Component
public class PayTimeOutAspect {

    @Autowired
    private Executor executor;

    @Pointcut("@annotation(com.day.day.up.main.annotation.TimeOut)")
    public void pointCut(){

    }

    @Around("pointCut()")
    public Object proceed(ProceedingJoinPoint point) throws InterruptedException, ExecutionException {
        log.info("限流拦截到了{}方法...", point.getSignature().getName());
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        long compare = 0L;
        int i = 0;
        if (method.isAnnotationPresent(TimeOut.class)) {
            compare = method.getAnnotation(TimeOut.class).value();
        }
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future future = executor.submit(() -> {
            log.info("正在执行");
            try {
                return point.proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
                return "操作失败";
            }
        });
        long t = System.currentTimeMillis();
        while (true) {
            Thread.sleep(9000);
            log.info("第{}次执行", i++);
            long cost = System.currentTimeMillis() - t;
            log.info("it cost {} ms", cost);
            log.info("--------------");
            if (cost > compare) {
                return "超时,TimeOut:"+compare;
            }
            if (future.isDone()) {
                //这个是test12返回的内容 eg:success
                return future.get();
            }
        }
    }

}
