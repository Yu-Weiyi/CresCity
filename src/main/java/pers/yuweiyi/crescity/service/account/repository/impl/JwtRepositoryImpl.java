package pers.yuweiyi.crescity.service.account.repository.impl;
/*
 * @file        JwtRepositoryImpl
 * @brief       JWT存储器实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.crescity.service.account.configuration.JwtConfiguration;
import pers.yuweiyi.crescity.service.account.repository.JwtRepository;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Description: JWT存储器接口实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.13
 */
@Repository
@Slf4j
public class JwtRepositoryImpl implements JwtRepository {

    @Autowired
    private ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
    @Autowired
    private JwtConfiguration jwtConfiguration;

    /**
     * @param uid 账户UID。
     * @param token JWT令牌。
     * @return void
     * @Description 创建JWT缓存。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public void create(String uid, String token) {

        reactiveRedisTemplate.opsForValue()
                .set(uid, token, Duration.ofMillis(jwtConfiguration.getTtl())).block();
    }

    /**
     * @param uid 账户UID。
     * @return Mono String
     * @Description 查询JWT缓存。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public Mono<String> retrieve(String uid) {

        Mono<String> token = reactiveRedisTemplate.opsForValue()
                .get(uid);
        return token;
    }

    /**
     * @param uid 账户UID。
     * @return void
     * @Description 删除JWT缓存。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public void delete(String uid) {

        reactiveRedisTemplate.opsForValue()
                .delete(uid)
                .block();
    }
}
