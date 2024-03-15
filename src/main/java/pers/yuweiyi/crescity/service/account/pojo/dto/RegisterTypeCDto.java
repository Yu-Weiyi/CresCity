package pers.yuweiyi.crescity.service.account.pojo.dto;
/*
 * @file        RegisterTypeCDto
 * @brief       公民类别账户注册传输对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: 公民类别账户注册传输对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.2
 * @since 2024.03.09
 */
@Data
@Schema(description = "公民类别账户注册传输对象")
public class RegisterTypeCDto implements Serializable {

    @Schema(description = "身份证号")
    @NotNull
    private String idCardNum;
    @Schema(description = "真实姓名")
    @NotNull
    private String realName;
    @Schema(description = "中文昵称")
    @NotNull
    private String nickName;
    @Schema(description = "设置密码")
    @NotNull
    private String password;
}
