package pers.yuweiyi.crescity.thirdparty.identityverification.pojo.dto;
/*
 * @file        VerifyDto
 * @brief       实名认证传输对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.08
 * @last_edit   2024.03.08
 */

import lombok.Data;

import java.io.Serializable;

/**
 * Description: 实名认证传输对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.08
 */
@Data
public class VerifyDto implements Serializable {
    private String idCardNum;
    private String realName;
}
