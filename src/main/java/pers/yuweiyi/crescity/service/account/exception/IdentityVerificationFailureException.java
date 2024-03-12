package pers.yuweiyi.crescity.service.account.exception;
/*
 * @file        IdentityVerificationFailureException
 * @brief       实名认证失败异常。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import lombok.NoArgsConstructor;

/**
 * Description:  实名认证失败异常。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.09
 */
@NoArgsConstructor
public class IdentityVerificationFailureException extends BaseException {

    public IdentityVerificationFailureException(String msg) {

        super(msg);
    }
}
