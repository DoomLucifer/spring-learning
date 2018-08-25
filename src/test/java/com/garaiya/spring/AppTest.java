package com.garaiya.spring;

import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
        ClassPathXmlApplicationContext classPathXmlApplicationContext;
        DefaultResourceLoader defaultResourceLoader;
        ResourcePatternResolver resourcePatternResolver;
    }

    @Test
    public void testResourceLoad(){
        ByteArrayInputStream bis = new ByteArrayInputStream("Hello World!".getBytes());
        Resource resource = new InputStreamResource(bis);
        Assert.assertEquals(true,resource.isOpen());

        ResourceLoader loader = new DefaultResourceLoader();
        Resource resource1 = loader.getResource("classpath:com/garaiya/spring/config/test.txt");
        System.out.println(resource1.getFilename());
        //验证返回的是ClasspathResource
        Assert.assertEquals(ClassPathResource.class,resource.getClass());

        Resource resource2 = loader.getResource("file:/Users/zhengguoqiang/IdeaProjects/garaiya/spring-learning/src/main/resources/test.txt");
        System.out.println(resource2.exists());
        Assert.assertEquals(UrlResource.class,resource2.getClass());
    }

    @Test
    public void testClasspathPrefix(){
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            Resource[] resources = resolver.getResources("classpath:test.txt");
            Assert.assertEquals(1,resources.length);

            Resource[] resources1 = resolver.getResources("classpath:config/*.txt");
            Assert.assertTrue(resources1.length > 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
