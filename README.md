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
