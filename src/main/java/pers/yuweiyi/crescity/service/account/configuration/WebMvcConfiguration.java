package pers.yuweiyi.crescity.service.account.configuration;
/*
 * @file        InterCeptorConfiguration
 * @brief       网络配置。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.22
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import pers.yuweiyi.crescity.service.account.interceptor.JwtTokenInterceptor;

/**
 * Description: 网络配置。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.14
 */
@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Autowired
    private JwtTokenInterceptor jwtTokenInterceptor;

    /**
     * @Description  注册拦截器。
     * @param interceptorRegistry
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public void addInterceptors(InterceptorRegistry interceptorRegistry) {

        log.info("注册拦截器。");
        interceptorRegistry.addInterceptor(jwtTokenInterceptor)
                .addPathPatterns("/**")
                //third party
                .excludePathPatterns("/v3/api-docs/**")//api-docs
                .excludePathPatterns("/swagger-ui/**")//swagger-ui
                .excludePathPatterns("/doc.html")//knife4j
                //crescity
                .excludePathPatterns("/register/**")
                .excludePathPatterns("/login/**");
    }

    /**
     * @Description  注册资源处理器。
     * @param resourceHandlerRegistry
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {

        log.info("注册资源处理器。");
        resourceHandlerRegistry
                .addResourceHandler("doc.html")//knife4j
                .addResourceLocations("classpath:/META-INF/resources/");
        resourceHandlerRegistry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}
