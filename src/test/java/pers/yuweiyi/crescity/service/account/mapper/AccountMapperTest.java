package pers.yuweiyi.crescity.service.account.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pers.yuweiyi.crescity.service.account.pojo.dao.AccountDao;

import static org.junit.jupiter.api.Assertions.*;

/*
 * @file        AccountMapperTest
 * @brief       在此处添加描述。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.11
 * @last_edit   2024.03.11
 */
@SpringBootTest
class AccountMapperTest {

    @Autowired
    AccountMapper accountMapper;

    @Test
    void test1() {//success
        System.out.println(accountMapper.retrieveExistence("T0"));
        System.out.println(accountMapper.retrieveExistence("C210404200202040637"));
    }
    @Test
    void test2() {
        accountMapper.create(new AccountDao("T1", "testpasswordhash"));
        System.out.println(accountMapper.retrieveExistence("T1"));
    }

}