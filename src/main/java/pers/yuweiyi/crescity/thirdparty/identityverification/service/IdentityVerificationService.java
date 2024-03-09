package pers.yuweiyi.crescity.thirdparty.identityverification.service;
/*
 * @file        IdentityVerificationService
 * @brief       实名认证服务接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.08
 * @last_edit   2024.03.08
 */

import pers.yuweiyi.crescity.thirdparty.identityverification.pojo.result.Result;

/**
 * Description: 实名认证服务接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.08
 */
public interface IdentityVerificationService {
    Result verify(String idCardNum);
}
