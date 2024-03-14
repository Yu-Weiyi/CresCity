package pers.yuweiyi.crescity.service.account.configuration;
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
import org.springframework.stereotype.Component;

/**
 * Description: 网络客户端配置。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.13
 */
@Configuration
@ConfigurationProperties(prefix = "crescity.webclient")
@Component
@Data
public class WebClientConfiguration {

//    @Value("crescity.webclient.host")
    private String host;
//    @Value("crescity.webclient.port")
    private String port;
    private Integer connectionTimeout;
    private Integer responseTimeout;
}
