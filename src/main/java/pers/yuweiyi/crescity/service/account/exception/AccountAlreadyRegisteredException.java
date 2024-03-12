package pers.yuweiyi.crescity.service.account.exception;
/*
 * @file        AccountAlreadyRegisteredException
 * @brief       账户重复注册异常。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import lombok.NoArgsConstructor;

/**
 * Description: 账户重复注册异常。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.09
 */
@NoArgsConstructor
public class AccountAlreadyRegisteredException extends BaseException{

    public AccountAlreadyRegisteredException(String msg) {

        super(msg);
    }
}
