package pers.yuweiyi.crescity.service.account.service.impl;
/*
 * @file        JwtServiceImpl
 * @brief       JWT服务实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.yuweiyi.crescity.service.account.configuration.JwtConfiguration;
import pers.yuweiyi.crescity.service.account.repository.JwtRepository;
import pers.yuweiyi.crescity.service.account.service.JwtService;
import pers.yuweiyi.crescity.service.account.util.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Description: JWT服务实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
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
    public String createToken(String uid) {

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
    public void storeToken(String uid, String token) {

        jwtRepository.create(uid, token);
    }
}
