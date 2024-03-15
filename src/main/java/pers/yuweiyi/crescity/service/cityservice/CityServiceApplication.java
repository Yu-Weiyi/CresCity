package pers.yuweiyi.crescity.service.cityservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@EnableConfigurationProperties
@ConfigurationPropertiesScan
@EnableReactiveMongoRepositories
@Slf4j
public class CityServiceApplication {

    /**
     * @Description  程序启动入口。
     * @param args 启动参数。
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    public static void main(String[] args) {

        SpringApplication.run(CityServiceApplication.class, args);
        log.info("新月城服-服务-城市服务 程序已启动。");
    }

}
