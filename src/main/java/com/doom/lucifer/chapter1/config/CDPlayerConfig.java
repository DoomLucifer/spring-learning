package com.doom.lucifer.chapter1.config;

import com.doom.lucifer.chapter1.soundsystem.CDPlayer;
import com.doom.lucifer.chapter1.soundsystem.CompactDisc;
import com.doom.lucifer.chapter1.soundsystem.SgtPeppers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * lucifer
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
@Configuration
//ComponentScan注解默认扫描与配置类相同的包,字符串形式当重构时容易产生类型不安全（not type-safe）
//@ComponentScan(basePackages = {"com.doom.lucifer.chapter1.soundsystem"})
//扫描空标记接口所在的包
//@ComponentScan(basePackageClasses = {MarkInterface.class})
public class CDPlayerConfig {

    /*
     被@Bean注解标注的方法，当被调用时都会被Spring进行拦截，
     确保直接返回容器里的bean，而不是每次都进行实际的调用
     */
    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

//    @Bean
//    public CDPlayer cdPlayer() {
//        return new CDPlayer(sgtPeppers());
//    }

    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc){
        CDPlayer cdPlayer = new CDPlayer();
        cdPlayer.setCompactDisc(compactDisc,compactDisc);
        return cdPlayer;
//        return new CDPlayer(compactDisc);
    }
}
