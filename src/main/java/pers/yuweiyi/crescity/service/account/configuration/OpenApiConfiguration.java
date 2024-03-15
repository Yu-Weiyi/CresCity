package pers.yuweiyi.crescity.service.account.configuration;
/*
 * @file        OpenApiConfiguration
 * @brief       OpenAPI配置。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.15
 * @last_edit   2024.03.15
 */

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description: OpenAPI配置。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.15
 */
@Configuration
@AutoConfigureBefore(SpringDocConfiguration.class)
@Slf4j
public class OpenApiConfiguration {

    /**
     * @Description  配置接口文档信息。
     * @return OpenAPI
     * @Author 于魏祎 Yu Weiyi
     */
    @Bean
    public OpenAPI openApi() {

        log.info("配置接口文档信息。");
        OpenAPI openApi = new OpenAPI()
                .info(
                        new Info()
                                .title("新月城服-服务-账户 OpenAPI接口文档")
                                .description("CresCity-Service-Account OpenAPI Document")
                                .contact(
                                        new Contact()
                                                .name("于魏祎")
                                                .email("yu_weiyi@outlook.com")
                                                .url("https://github.com/Yu-Weiyi")
                                )
                                .version("version 1.0.0")//TEMP
                )
//                .externalDocs()
//                .components()
        ;
        return openApi;
    }
}
