package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * Created by silvester on 2017/7/26.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {
    String[] value() default {};

    String[] authorities() default {};

    String[] roles() default {};
}
