package pers.yuweiyi.crescity.service.account.pojo.dto;
/*
 * @file        IdentityVerificationDto
 * @brief       实名认证传输对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.10
 * @last_edit   2024.03.10
 */

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Description: 实名认证传输对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.10
 */
@AllArgsConstructor
@Data
public class IdentityVerificationDto implements Serializable {

    private String idCardNum;
    private String realName;
}
