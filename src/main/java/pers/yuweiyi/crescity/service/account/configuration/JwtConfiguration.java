package pers.yuweiyi.crescity.service.account.configuration;
/*
 * @file        JwtConfiguration
 * @brief       JWT配置。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Description: JWT配置。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.13
 */
@Configuration
@ConfigurationProperties(prefix = "crescity.jwt")
@Component
@Data
public class JwtConfiguration {

    private String secretKey;
    private long ttl;
}
