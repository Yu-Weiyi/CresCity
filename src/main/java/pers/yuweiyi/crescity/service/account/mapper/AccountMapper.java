package pers.yuweiyi.crescity.service.account.mapper;
/*
 * @file        AccountMapper
 * @brief       账户映射器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.10
 * @last_edit   2024.03.22
 */

import org.apache.ibatis.annotations.Mapper;
import pers.yuweiyi.crescity.service.account.pojo.dao.AccountDao;

/**
 * Description: 账户映射器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.10
 */
@Mapper
public interface AccountMapper {

    /**
     * @Description  增加账户记录。
     * @param newAccountDao
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    void create(AccountDao newAccountDao);

    /**
     * @Description  查询账户记录存在。
     * @param uid
     * @return boolean
     * @Author 于魏祎 Yu Weiyi
     */
    boolean retrieveExistence(String uid);

    /**
     * @Description  查询加密密码。
     * @param uid 账户UID。
     * @return String
     * @Author 于魏祎 Yu Weiyi
     */
    String retrievePasswordHash(String uid);

    /**
     * @Description  更新账户记录。
     * @param accountDao
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    void updatePasswordHash(AccountDao accountDao);
}
