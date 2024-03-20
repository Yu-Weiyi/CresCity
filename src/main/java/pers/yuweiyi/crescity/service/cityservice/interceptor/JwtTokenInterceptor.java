package pers.yuweiyi.crescity.service.cityservice.interceptor;
/*
 * @file        JwtTokenInterceptor
 * @brief       JWT令牌拦截器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.HandlerInterceptor;
import pers.yuweiyi.crescity.service.cityservice.configuration.JwtConfiguration;
import pers.yuweiyi.crescity.service.cityservice.context.BaseContext;
import pers.yuweiyi.crescity.service.cityservice.pojo.result.Result;
import pers.yuweiyi.crescity.service.cityservice.util.WebClientUtil;

/**
 * Description: JWT令牌拦截器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.14
 */
@Component
@Slf4j
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtConfiguration jwtConfiguration;

    @Autowired
    private WebClientUtil webClientUtil;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        log.debug("JWT校验。");
        try {
            String token = request.getHeader(jwtConfiguration.getTokenName());
            WebClient.ResponseSpec responseSpec =  webClientUtil.request(HttpMethod.POST, "http://localhost:8080/api/service/account/authentication", "", token);
            Result<String> result = responseSpec.bodyToMono(Result.class).block();
            String uid = result.getData();
            BaseContext.createUid(uid);
            return true;
        }
        catch (Exception ex) {
            response.setStatus(401);//返回认证失败状态码
            return false;
        }
    }
}
