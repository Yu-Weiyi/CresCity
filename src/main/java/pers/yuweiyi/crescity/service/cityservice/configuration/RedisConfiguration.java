package pers.yuweiyi.crescity.service.cityservice.configuration;
/*
 * @file        RedisConfiguration
 * @brief       Redis配置。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Description: Redis配置。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.13
 */
@Configuration
@Slf4j
public class RedisConfiguration {

    @Bean
    public RedisSerializationContext redisSerializationContext() {

        log.info("初始化Redis序列化器。");
        RedisSerializationContext.RedisSerializationContextBuilder redisSerializationContextBuilder = RedisSerializationContext.newSerializationContext();
        redisSerializationContextBuilder.key(StringRedisSerializer.UTF_8);
        redisSerializationContextBuilder.value(RedisSerializer.json());
        redisSerializationContextBuilder.hashKey(StringRedisSerializer.UTF_8);
        redisSerializationContextBuilder.hashValue(StringRedisSerializer.UTF_8);
        return redisSerializationContextBuilder.build();
    }

    @Bean
    public ReactiveRedisTemplate reactiveRedisTemplate(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {

        log.info("初始化Redis客户端。");
        RedisSerializationContext redisSerializationContext = redisSerializationContext();
        ReactiveRedisTemplate reactiveRedisTemplate = new ReactiveRedisTemplate<String, Object>(reactiveRedisConnectionFactory, redisSerializationContext);
        return reactiveRedisTemplate;
    }
}
