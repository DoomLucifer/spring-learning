[TOC]
# spring-learning
## bean装配
### 自动装配
@Autowired注解实现自动装配，自动装配就是Spring解决bean依赖的一种方法

@Autowired注解即可在构造器上，还可用在属性的setter方法上，也可用于`任意`方法上

@Inject,@Name注解均来源于Java依赖注入规范，其与@Autowired，@Component（Spring特有）注解
有些细微的差别，但是在大多数场景下，它们可以相互替换
### Java代码装配bean
@Bean注解作用于方法上，并将方法返回的实例注册到Spring容器中。

### XML装配bean
1. 构造器注入
2. 属性注入

通用规则：强依赖采用构造器注入，可选性依赖使用属性注入

### 混合装配
```java
//JavaConfig中导入JavaConfig配置或者xml配置
@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:ApplicationContext.xml")
public class SoundSystemConfig {
}
```
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:c="http://www.springframework.org/schema/c" xmlns:util="http://www.springframework.org/schema/util"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/util http://www.springframework.org/schema/util/spring-util.xsd">

    <!-- xml中导入JavaConfig配置或者xml配置 -->
    <!-- 导入JavaConfig配置 -->
    <bean class="com.doom.lucifer.chapter1.config.CDPlayerConfig"/>

    <!-- 导入xml配置 -->
    <import resource="classpath:ApplicationContext.xml"/>
</beans>

```
> 应该优先选择JavaConfig的方式，它比xml配置方式更加强大，类型安全并且易于重构

## 高级装配
### Spring profile
@Profile注解指定某个bean属于哪一个profile，这种方式Spring是在运行阶段才确定的
，相比于Maven的profiles是在编译阶段完成此操作，风险要小很多

**激活profile**

依赖两个独立的属性：spring.profiles.default和spring.profiles.active

一种比价好的方式：
1. 在web应用的web.xml文件中设置默认的profile
```xml
<!--为上下文设置默认的profile-->
<context-param>
    <param-name>spring.profiles.default</param-name>
    <param-value>dev</param-value>
</context-param>
```
```xml
<!--为Servlet设置默认的profile-->
<servlet>
    <init-param>
        <param-name>spring.profiles.default</param-name>
        <param-value>dev</param-value>
    </init-param>
</servlet>

```

Junit测试时可借助@ActiveProfiles注解来激活哪个环境的bean
### 条件化的bean声明

@Conditional注解，可以用到带有@Bean注解的方法上。如果给定的条件为true，
则创建该bean，否则不创建该bean

### 自动装配与歧义性

两种方式解决歧义（多个bean不知道选哪个，Spring会抛出NoUniqueBeanDefinitionException）:
1. @Primary标示首选的bean
2. @Qualifier限定唯一bean

**自定义注解**

### bean的作用域

1. 单例（Singleton）
2. 原型（Prototype）
3. 会话（Session）
4. 请求（Request）

自动装配及javaconfig的配置方式使用@Scope注解指定作用域，xml配置方式使用scope属性指定作用域


### Spring表达式语言

避免硬编码，想让值在运行时再确定，Spring提供了两种方式：

1. 属性占位符（Property placeholder）
2. Spring表达式语言（SpEL）

**属性占位符**

使用形式：${...}

Spring context命名空间的<context:property-placeholder/>元素将会生成
PropertySourcesPlaceholderConfigurer(Spring3.1开始推荐使用，
因为它能够基于Spring Environment及其属性源来解析占位符) bean

**SpEL**

使用形式：#{...}

