package pers.yuweiyi.crescity.service.account.repository;
/*
 * @file        AccountProfileReactiveRepository
 * @brief       账户资料响应式存储器接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.12
 * @last_edit   2024.03.12
 */

/**
 * Description: 账户资料响应式存储器接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.12
 */
public interface AccountProfileReactiveRepository {

    /**
     * @Description  新建文档。
     * @param newUid 新账户uid。
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    void create(String newUid);

    /**
     * @Description  当注册市民账户时，更新（初始化）文档。
     * @param uid 账户uid。
     * @param idCardNum 身份证号。
     * @param realName 真实（中文）姓名。
     * @param nickName （中文）网名。
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    void updateWhenRegisterTypeC(String uid, String idCardNum, String realName, String nickName);
}
