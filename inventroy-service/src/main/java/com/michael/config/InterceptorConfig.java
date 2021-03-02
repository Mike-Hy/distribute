package com.michael.config;

import com.michael.interceptor.IdempotenceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @ClassName InterceptorConfig
 * @Description TODO
 * @Author Michael.Ng
 * @Date 2021/2/20 15:46
 **/
@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {

        public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new IdempotenceInterceptor()).addPathPatterns("/**");
        }
}