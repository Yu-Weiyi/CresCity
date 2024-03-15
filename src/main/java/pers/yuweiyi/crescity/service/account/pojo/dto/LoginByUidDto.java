package pers.yuweiyi.crescity.service.account.pojo.dto;
/*
 * @file        LoginByUidDto
 * @brief       账号密码方式登录传输对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: 账号密码方式登录传输对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.13
 */
@Data
@Schema(description = "账号密码方式登录传输对象")
public class LoginByUidDto implements Serializable {

    @Schema(description = "账户UID")
    @NotNull
    private String uid;
    @Schema(description = "密码")
    @NotNull
    private String password;
}
