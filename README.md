# IOCView
一、该项目主要是展示依赖注入的功能实现，其中运用到了如下知识: 
1、依赖注入的实现
2、自定义注解的使用 
3、反射的使用

二、使用方法
1、注解对象
@FindViewByIdAnnotation(id = R.id.tvHello, onClick = "onClickHello")
private TextView tvHello;

2、在相应位置调用：FindViewUtil.initView(this);
Activity:在onCreate中调用
Fragment:在onActivityCreated调用


三、IoC简介
控制反转（Inversion of Control，英文缩写为IoC）是一个重要的面向对象编程的法则来削减计算机程序的耦合问题，也是轻量级的Spring框架的核心。 控制反转一般分为两种类型，依赖注入（Dependency Injection，简称DI）和依赖查找（Dependency Lookup）。依赖注入应用比较广泛 依赖注入即IOC模式，也叫反转控制。即IoC是一种设计模式
