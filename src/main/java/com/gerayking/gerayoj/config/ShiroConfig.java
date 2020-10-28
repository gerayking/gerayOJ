package com.gerayking.gerayoj.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ShiroConfig {
    @Bean
    MyRealm getMyRealm(){
        return new MyRealm();
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(getMyRealm());
        return manager;
    }
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager());
        HashMap<String, String> Map = new HashMap<>();
        return factoryBean;
    }
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }
}
