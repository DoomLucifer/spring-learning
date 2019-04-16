package com.doom.lucifer.chapter1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * lucifer
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
@Configuration
@Import(CDPlayerConfig.class)
@ImportResource("classpath:chapter1/ApplicationContext.xml")
public class SoundSystemConfig {
}
