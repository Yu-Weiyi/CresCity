package pers.yuweiyi.crescity.thirdparty.identityverification.service.impl;
/*
 * @file        IdentityVerificationServiceImpl
 * @brief       实名认证服务实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.08
 * @last_edit   2024.03.08
 */

import cn.hutool.core.util.IdcardUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pers.yuweiyi.crescity.thirdparty.identityverification.pojo.result.Result;
import pers.yuweiyi.crescity.thirdparty.identityverification.service.IdentityVerificationService;

/**
 * Description: 实名认证服务实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.08
 */
@Service
@Slf4j
public class IdentityVerificationServiceImpl implements IdentityVerificationService {

    @Override
    public Result verify(String idCardNum) {
        boolean isValid = IdcardUtil.isValidCard(idCardNum);
        log.debug(idCardNum + isValid);
        Result result;
        if (isValid) {
            result = Result.success();
        }
        else {
            result = Result.error("U0003", "实名认证失败");
        }
        return result;
    }
}
