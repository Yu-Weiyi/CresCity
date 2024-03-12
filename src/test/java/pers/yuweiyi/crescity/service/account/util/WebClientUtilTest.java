package pers.yuweiyi.crescity.service.account.util;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import pers.yuweiyi.crescity.service.account.pojo.dao.AccountProfileDao;
import pers.yuweiyi.crescity.service.account.pojo.dto.IdentityVerificationDto;
import pers.yuweiyi.crescity.service.account.pojo.result.Result;
import pers.yuweiyi.crescity.service.account.repository.AccountProfileReactiveRepository;
import pers.yuweiyi.crescity.service.account.repository.mongo.AccountProfileReactiveMongoRepository;
import reactor.core.publisher.Mono;

/*
 * @file        WebClientUtilTest
 * @brief       在此处添加描述。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.10
 * @last_edit   2024.03.10
 */
@SpringBootTest
class WebClientUtilTest {

    @Autowired
    WebClientUtil webClientUtil;

    @Autowired
    AccountProfileReactiveMongoRepository accountProfileReactiveMongoRepository;

    @Autowired
    AccountProfileReactiveRepository accountProfileReactiveRepository;

    @Test
    void test1() {
        System.out.println(webClientUtil.getHost());
        System.out.println(webClientUtil.getConnectionTimeout());
    }

    @Test
    void test2() {
        WebClient.ResponseSpec r = webClientUtil.request(HttpMethod.POST, "http://8.137.62.188:30001/api/third_party/identity_verification/verify", MediaType.APPLICATION_JSON, 10000, new IdentityVerificationDto("210404200202040638", "ywy"));
        Result result = r.bodyToMono(Result.class).block();

        System.out.println(result.getCode());
    }

    @Test
    void test3() {
        WebClient.ResponseSpec r = webClientUtil.request(HttpMethod.POST, "/api/third_party/identity_verification/verify", "", new IdentityVerificationDto("210404200202040637", "ywy"));
        Result result = r.bodyToMono(Result.class).block();

        System.out.println(result.getCode());
    }

    @Test
    void test4() {
        Mono<AccountProfileDao> mono = accountProfileReactiveMongoRepository.findById(new ObjectId("000000000000000000000000"));
        AccountProfileDao accountProfileDao = mono.block();
        System.out.println(accountProfileDao);
        System.out.println(accountProfileDao.getBind().getClass());
    }

    @Test
    void test5() {//不block()不执行。
        System.out.println(accountProfileReactiveMongoRepository.save(new AccountProfileDao("T1")).block().getUid());
    }

    @Test
    void test6() {//不block()不执行。
        accountProfileReactiveRepository.create("C210404200202040637");
        accountProfileReactiveRepository.updateWhenRegisterTypeC("C210404200202040637", "210404200202040637", "于魏祎", "为伊WaYease");
    }

    @Test
    void test7() {
        System.out.println(webClientUtil.request(HttpMethod.POST, "http://8.137.62.188:30001/api/third_party/identity_verification/verify", MediaType.APPLICATION_JSON, 10000, new IdentityVerificationDto("210404200202040637", "asd")).bodyToMono(Result.class).block());
    }
}