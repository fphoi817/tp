package com.tensquare.qa.config;

import com.tensquare.qa.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration {

    @Autowired
    private JwtFilter jwtFilter;

    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            // 重写父类提供的跨域请求处理的接口
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // super.addCorsMappings(registry);
                // 添加映射路径
                registry.addMapping("/**")
                        // 放行哪些原始域
                        .allowedOrigins("*")
                        // 是否发送Cookie信息
                        .allowCredentials(true)
                        // 放行哪些原始域(请求方式)
                        .allowedMethods("GET", "POST", "PUT", "DELETE")
                        // 放行哪些原始域(头部信息)
                        .allowedHeaders("*");
                        // 暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                        //.exposedHeaders("token");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(jwtFilter).addPathPatterns("/**")
                        .excludePathPatterns("/**/login/**");
            }
        };
    }

}
