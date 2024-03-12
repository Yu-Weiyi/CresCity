package pers.yuweiyi.crescity.service.account.pojo.dto;
/*
 * @file        RegisterTypeCDto
 * @brief       公民类别账户注册传输对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import lombok.Data;

import java.io.Serializable;

/**
 * Description: 公民类别账户注册传输对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.09
 */
@Data
public class RegisterTypeCDto implements Serializable {

    private String idCardNum;
    private String realName;
    private String nickName;
    private String passwordHash;
}
