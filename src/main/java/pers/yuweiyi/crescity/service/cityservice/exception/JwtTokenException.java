package pers.yuweiyi.crescity.service.cityservice.exception;
/*
 * @file        JwtTokenException
 * @brief       JWT异常。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

import lombok.NoArgsConstructor;

/**
 * Description: JWT异常。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.14
 */
@NoArgsConstructor
public class JwtTokenException extends BaseException{

    public JwtTokenException(String msg) {

        super(msg);
    }
}
