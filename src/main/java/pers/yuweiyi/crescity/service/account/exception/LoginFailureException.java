package pers.yuweiyi.crescity.service.account.exception;
/*
 * @file        LoginFailureException
 * @brief       登陆失败异常。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

import lombok.NoArgsConstructor;

/**
 * Description: 登陆失败异常。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.14
 */
@NoArgsConstructor
public class LoginFailureException extends BaseException{

    public LoginFailureException(String msg) {

        super(msg);
    }
}
