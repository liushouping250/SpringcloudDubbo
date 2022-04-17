package com.dubbo.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/17 0:24
 */
@Component
@Aspect
public class SysLogAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 以所有添加了 SysLog 注解的方法为切点
     */
    @Pointcut("@annotation(com.dubbo.demo.aop.SysLog)")
    public void logAspect() {
    }

    /**
     * 前置增强
     */
    @Before("logAspect()")
    public void doBefore() {
        logger.info("==========doBefore==========");
    }

    /**
     * 正常返回增强
     */
    @AfterReturning("logAspect()")
    public void doAfterReturning() {
        logger.info("==========doAfterReturning==========");
    }

    /**
     * 异常返回增强
     */
    @AfterThrowing("logAspect()")
    public void doAfterThrowing() {
        logger.info("==========doAfterThrowing==========");
    }

    /**
     * 后置通知
     */
    @After("logAspect()")
    public void doAfter() {
        logger.info("==========doAfter==========");
    }

    /**
     * 环绕增强
     */
    @Around("logAspect()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            logger.info("==========doAround before==========");
            // 调用proceed()方法目标方法才会执行，这是环绕增强控制目标方法执行的关键
            Object o = proceedingJoinPoint.proceed();
            logger.info("==========doAround after==========");
            return o;
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }
}
