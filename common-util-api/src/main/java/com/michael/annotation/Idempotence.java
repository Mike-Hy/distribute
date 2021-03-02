package com.michael.annotation;

import java.lang.annotation.*;

/**
 * 幂等性注解，作用范围，方法
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Idempotence {

}
