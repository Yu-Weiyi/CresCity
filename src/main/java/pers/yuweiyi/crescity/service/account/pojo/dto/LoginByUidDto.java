package pers.yuweiyi.crescity.service.account.pojo.dto;
/*
 * @file        LoginByUidDto
 * @brief       账号密码方式登录传输对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import lombok.Data;

import java.io.Serializable;

/**
 * Description: 账号密码方式登录传输对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.13
 */
@Data
public class LoginByUidDto implements Serializable {

    private String uid;
    private String password;
}
