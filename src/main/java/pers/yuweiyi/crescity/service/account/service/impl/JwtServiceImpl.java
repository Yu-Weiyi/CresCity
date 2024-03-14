package pers.yuweiyi.crescity.service.account.service.impl;
/*
 * @file        JwtServiceImpl
 * @brief       JWT服务实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.yuweiyi.crescity.service.account.configuration.JwtConfiguration;
import pers.yuweiyi.crescity.service.account.constant.ExceptionConstant;
import pers.yuweiyi.crescity.service.account.exception.JwtTokenException;
import pers.yuweiyi.crescity.service.account.repository.JwtRepository;
import pers.yuweiyi.crescity.service.account.service.JwtService;
import pers.yuweiyi.crescity.service.account.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: JWT服务实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.13
 */
@Service
@Slf4j
public class JwtServiceImpl implements JwtService {

    @Autowired
    private JwtConfiguration jwtConfiguration;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private JwtRepository jwtRepository;

    /**
     * @param uid 账户UID。
     * @return String
     * @Description 创建JWT令牌。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public String buildToken(String uid) {

        //组装claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("uid", uid);

        String token = jwtUtil.create(jwtConfiguration.getSecretKey(), jwtConfiguration.getTtl(), claims);
        return token;
    }

    /**
     * @param uid   账户UID。
     * @param token JWT令牌。
     * @return
     * @Description 缓存JWT令牌。。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public void createToken(String uid, String token) {

        jwtRepository.create(uid, token);
    }

    /**
     * @param uid 账户UID。
     * @return void
     * @Description 删除JWT令牌。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public void deleteToken(String uid) {

        jwtRepository.delete(uid);
    }

    /**
     * @param uid 账户UID。
     * @return String
     * @Description 查询JWT令牌。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public String retrieveToken(String uid) {

        return jwtRepository.retrieve(uid).block();
    }

    /**
     * @param token 令牌。
     * @return String
     * @Description 校验JWT令牌。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public String verifyToken(String token) {

        log.debug("校验JWT。");
        Claims claims =  jwtUtil.retrieve(jwtConfiguration.getSecretKey(), token);
        String uid = claims.get("uid").toString();
        String cachedToken = retrieveToken(uid);
        if (cachedToken.equals(token)) {
            return uid;
        }
        else {
            throw new JwtTokenException(ExceptionConstant.USER_JWT_TOKEN_VERIFICATION_FAILURE);
        }
    }
}
