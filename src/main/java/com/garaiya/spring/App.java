package com.garaiya.spring;

import com.garaiya.spring.base.SimpleBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("config.xml");
        SimpleBean simpleBean = applicationContext.getBean(SimpleBean.class);
        simpleBean.send();
        applicationContext.close();
    }
}
