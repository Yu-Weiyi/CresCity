package pers.yuweiyi.crescity.service.cityservice.configuration;
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

/**
 * Description: JWT配置。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.2
 * @since 2024.03.13
 */
@Configuration
@ConfigurationProperties(prefix = "crescity.jwt")
@Data
public class JwtConfiguration {

    private String secretKey;
    private long ttl;
    private String tokenName;
}
