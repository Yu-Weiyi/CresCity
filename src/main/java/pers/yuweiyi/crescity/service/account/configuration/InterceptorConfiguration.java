package pers.yuweiyi.crescity.service.account.configuration;
/*
 * @file        InterCeptorConfiguration
 * @brief       拦截器配置。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import pers.yuweiyi.crescity.service.account.interceptor.JwtTokenInterceptor;

/**
 * Description: 拦截器配置。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.14
 */
@Configuration
@Slf4j
public class InterceptorConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtTokenInterceptor jwtTokenInterceptor;

    /**
     * @Description  注册拦截器。
     * @param interceptorRegistry
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    protected void addInterceptors(InterceptorRegistry interceptorRegistry) {

        log.info("注册拦截器。");
        interceptorRegistry.addInterceptor(jwtTokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/service/register/**")
                .excludePathPatterns("/api/service/login/**");
    }
}
