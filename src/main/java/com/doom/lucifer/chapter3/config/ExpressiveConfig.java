package com.doom.lucifer.chapter3.config;

import com.doom.lucifer.chapter1.soundsystem.BlankDisc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * lucifer
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
@Configuration
//声明属性源
@PropertySource(value = {"classpath:chapter3/app.properties"})
public class ExpressiveConfig {

    private final Environment environment;

    @Autowired
    public ExpressiveConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(
                environment.getProperty("disc.title"),
                environment.getProperty("disc.artist"),
                null, null);
    }
}
