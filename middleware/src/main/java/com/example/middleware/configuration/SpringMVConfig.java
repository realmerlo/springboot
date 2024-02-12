package com.example.middleware.configuration;

import com.example.middleware.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.middleware.interceptors.APILoggingInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class SpringMVConfig implements WebMvcConfigurer {

    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private LegacyInterceptor legacyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {        // Ordine degli interceptor
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(legacyInterceptor);
    }
}
