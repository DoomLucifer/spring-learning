package com.doom.lucifer.chapter3.soundsystem;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * lucifer
 *
 * @author <a href="mailto:zhengguoqiang@58.com">doom</a>
 */
@Component
//原型作用域
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

//会话作用域
@Scope(value = WebApplicationContext.SCOPE_SESSION,
        proxyMode = ScopedProxyMode.INTERFACES)
//proxyMode的作用：注入代理，当调用该bean的方法时，代理会对其进行懒解析并将调用委托给会话作用域内真正的bean
public class ScopeBean {
}
