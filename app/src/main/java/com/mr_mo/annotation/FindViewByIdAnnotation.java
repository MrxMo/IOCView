package com.mr_mo.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * View控件 注解
 * Created by Mr-Mo on 15/7/2 11:42.
 */
//@Target作用：用于描述注解的使用范围（即：被描述的注解可以用在什么地方）
//ElementType参数有：1.CONSTRUCTOR:用于描述构造器 2.FIELD:用于描述域 3.LOCAL_VARIABLE:用于描述局部变量
// 4.METHOD:用于描述方法 5.PACKAGE:用于描述包 6.PARAMETER:用于描述参数 7.TYPE:用于描述类、接口(包括注解类型) 或enum声明

//@Retention作用：用于描述注解的生命周期（即：被描述的注解在什么范围内有效）
//（RetentionPoicy）有：1.SOURCE:在源文件中有效（即源文件保留）2.CLASS:在class文件中有效（即class保留）3.RUNTIME:在运行时有效（即运行时保留）

//@Documented 表明这个注解被javadoc工具记录,默认是不被javadoc注解的. 即声明注解@Documented,则注解类型信息会被生成在文档中
//@Inherited指明被注解的类会自动继承，即：注解类中的所有属性与方法会被子类继承
    
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FindViewByIdAnnotation {

    int id() default 0;

    String onClick() default "";

}
