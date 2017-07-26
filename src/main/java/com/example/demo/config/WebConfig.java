package com.example.demo.config;

import com.example.demo.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by silvester on 2017/7/26.
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //定义过滤拦截的url名称，例如/hello/**，表示hello下所有的名称请求
        registry.addInterceptor(new AuthenticationInterceptor()).addPathPatterns("/**");

    }

}
