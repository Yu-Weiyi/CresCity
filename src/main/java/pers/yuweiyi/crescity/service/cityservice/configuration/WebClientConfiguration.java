package pers.yuweiyi.crescity.service.cityservice.configuration;
/*
 * @file        WebClientConfiguration
 * @brief       网络客户端配置。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Description: 网络客户端配置。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.13
 */
@Configuration
@ConfigurationProperties(prefix = "crescity.webclient")
@Data
public class WebClientConfiguration {

    private String host;
    private String port;
    private Integer connectionTimeout;
    private Integer responseTimeout;
}
