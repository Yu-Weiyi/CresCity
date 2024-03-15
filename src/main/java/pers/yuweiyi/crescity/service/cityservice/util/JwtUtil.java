package pers.yuweiyi.crescity.service.cityservice.util;
/*
 * @file        JwtUtil
 * @brief       JWT工具。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

/**
 * Description: JWT工具。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.13
 */
@Component
@Slf4j
public class JwtUtil {

    /**
     * @Description  创建JWT。
     * @param secretKey 密钥。
     * @param ttlMillis 过期时间。
     * @param claims 携带信息。
     * @return String
     * @Author 于魏祎 Yu Weiyi
     */
    public static String create(String secretKey, long ttlMillis, Map<String, Object> claims) {

        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;//未来替换为非对称密钥算法
        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm, secretKey.getBytes(StandardCharsets.UTF_8))
                .setExpiration(exp);
        return jwtBuilder.compact();
    }

    /**
     * @Description  解密JWT。
     * @param secretKey JWT密钥
     * @param token 令牌。
     * @return Claims
     * @Author 于魏祎 Yu Weiyi
     */
    public static Claims retrieve(String secretKey, String token) {

        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
