package com.demo.springboot.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: TestAnnotation
 * @Author: zhanghongkai
 * @Date: Create in 2019/7/22 17:35
 * @Version: 1.0
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String username();
    String password();
    Class type();
}
