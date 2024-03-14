package pers.yuweiyi.crescity.service.account.interceptor;
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
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import pers.yuweiyi.crescity.service.account.configuration.JwtConfiguration;
import pers.yuweiyi.crescity.service.account.context.BaseContext;
import pers.yuweiyi.crescity.service.account.service.JwtService;

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
    private JwtService jwtService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        log.debug("JWT校验。");
        try {
            String token = request.getHeader(jwtConfiguration.getTokenName());
            String uid = jwtService.verifyToken(token);
            BaseContext.createUid(uid);
            return true;
        }
        catch (Exception ex) {
            response.setStatus(401);//返回认证失败状态码
            return false;
        }
    }
}
