package pers.yuweiyi.crescity.service.account.pojo.dto;
/*
 * @file        PasswordChangeDto
 * @brief       账户密码修改数据传输对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.22
 * @last_edit   2024.03.22
 */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Description: 账户密码修改数据传输对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.22
 */
@Data
@Schema(description = "账户密码修改数据传输对象")
public class PasswordChangeDto {

    @Schema(description = "旧密码")
    @NotNull
    private String oldPassword;
    @Schema(description = "新密码")
    @NotNull
    private String newPassword;
}
