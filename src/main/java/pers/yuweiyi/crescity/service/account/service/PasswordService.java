package pers.yuweiyi.crescity.service.account.service;
/*
 * @file        PasswordService
 * @brief       账户密码服务接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.22
 * @last_edit   2024.03.22
 */

import pers.yuweiyi.crescity.service.account.pojo.dto.PasswordChangeDto;

/**
 * Description: 账户密码服务接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.22
 */
public interface PasswordService {

    /**
     * @Description  账户密码修改。
     * @param passwordChangeDto
     * @return String 账户UID
     * @Author 于魏祎 Yu Weiyi
     */
    String change(PasswordChangeDto passwordChangeDto);

    /**
     * @Description  账号密码校验。
     * @param uid 账户UID。
     * @param password 明文密码。
     * @return boolean
     * @Author 于魏祎 Yu Weiyi
     */
    boolean verify(String uid, String password);
}
