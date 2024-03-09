package pers.yuweiyi.crescity.thirdparty.identityverification.controller;
/*
 * @file        IdentityVerificationController
 * @brief       实名认证控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.08
 * @last_edit   2024.03.08
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yuweiyi.crescity.thirdparty.identityverification.pojo.dto.VerifyDto;
import pers.yuweiyi.crescity.thirdparty.identityverification.pojo.result.Result;
import pers.yuweiyi.crescity.thirdparty.identityverification.service.IdentityVerificationService;

/**
 * Description: 实名认证控制器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.08
 */
@RestController
@RequestMapping("/api/third_party/identity_verification")
@Slf4j
public class IdentityVerificationController {

    @Autowired
    private IdentityVerificationService identityVerificationService;

    @PostMapping("/verify")
    public Result verify(@RequestBody VerifyDto dto) {
        log.debug(dto.getIdCardNum() + dto.getRealName());
        Result result = identityVerificationService.verify(dto.getIdCardNum());
        return result;
    }
}
