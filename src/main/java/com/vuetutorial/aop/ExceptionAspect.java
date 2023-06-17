package com.vuetutorial.aop;

import com.vuetutorial.entity.result.Result;
import com.vuetutorial.entity.result.ResultEnum;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 通过Aop处理controller中出现的异常

@Slf4j
//@Aspect
//@Component
public class ExceptionAspect {

//    @Around("execution(* com.vuetutorial.controller.*.*(..))")
    public Object handleException(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        try {
            result = pjp.proceed();
        } catch (Exception e) {
            log.error("异常信息：{}", e.getMessage());
            Result<Object> r = new Result<>(ResultEnum.SERVER_ERROR,null);
            return r;
        }
        return result;
    }
}

