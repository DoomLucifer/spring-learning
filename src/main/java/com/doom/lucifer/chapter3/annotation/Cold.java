package com.doom.lucifer.chapter3.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义限定符注解
 * 拥有@Qualifier注解的特性
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
@Target({ElementType.TYPE,ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Cold {
}
