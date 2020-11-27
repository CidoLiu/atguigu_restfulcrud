package com.cido.springboot.config;

import com.cido.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 添加视图控制器，浏览器发送/cido请求，请求来到/index
        registry.addViewController("/cido").setViewName("/login");
    }

    // 注册自定义的localeResolver为组件，覆盖默认的
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
