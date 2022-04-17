package com.dubbo.demo.aop;

import java.lang.annotation.*;

/**
 * @author mr.monster
 * @version 1.0
 * @Description
 * @date 2022/4/17 0:23
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {


    String value() default "";
}
