package pers.yuweiyi.crescity.service.account.exception;
/*
 * @file        RegisterFailureException
 * @brief       注册失败异常。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

import lombok.NoArgsConstructor;

/**
 * Description: 注册失败异常。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.14
 */
@NoArgsConstructor
public class RegisterFailureException extends BaseException{

    public RegisterFailureException(String msg) {

        super(msg);
    }
}
