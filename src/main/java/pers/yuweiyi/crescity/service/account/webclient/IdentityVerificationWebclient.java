package pers.yuweiyi.crescity.service.account.webclient;
/*
 * @file        IdentityVerificationWebclient
 * @brief       实名认证网络客户端接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

/**
 * Description: 实名认证网络客户端接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.09
 */
public interface IdentityVerificationWebclient {

    /**
     * @Description  调用身份认证API。
     * @param idCardNum 身份证号
     * @param realName 真实姓名
     * @return boolean
     * @Author 于魏祎 Yu Weiyi
     */
    boolean verify(String idCardNum, String realName);
}
