package com.mr_mo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ContentView注解
 * Created by Mr-Mo on 15/7/2 11:53.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FindContentViewAnnotation {

    int value() default 0;

}
