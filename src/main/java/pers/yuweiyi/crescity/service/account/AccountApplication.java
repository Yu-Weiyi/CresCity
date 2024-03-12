package pers.yuweiyi.crescity.service.account;
/*
 * @file        AccountApplication
 * @brief       应用程序入口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Description: 应用程序入口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.09
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableReactiveMongoRepositories
@Slf4j
public class AccountApplication {

    /**
     * @Description  程序启动入口。
     * @param args 启动参数。
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    public static void main(String[] args) {
        SpringApplication.run(AccountApplication.class, args);
        log.info("新月城服-服务-账户 程序已启动。");
    }
}
