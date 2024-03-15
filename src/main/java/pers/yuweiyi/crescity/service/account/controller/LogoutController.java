package pers.yuweiyi.crescity.service.account.controller;
/*
 * @file        LogoutController
 * @brief       账户登出控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yuweiyi.crescity.service.account.pojo.result.Result;
import pers.yuweiyi.crescity.service.account.service.LogoutService;

/**
 * Description: 账户登出控制器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.2
 * @since 2024.03.14
 */
@RestController
@RequestMapping("/logout")
@Tag(name = "账户登出接口", description = "账户登出接口")
@ApiSupport(author = "于魏祎 yu_weiyi@outlook.com")
@Slf4j
public class LogoutController {

    @Autowired
    private LogoutService logoutService;

    /**
     * @Description  登出接口。
     * @return Result String 账户UID。
     * @Author 于魏祎 Yu Weiyi
     */
    @DeleteMapping
    @Operation(
            summary = "账户登出接口", description = "账户登出接口",
            responses = {
                    @ApiResponse(responseCode = "200-00000", description = "正常返回已登出账户UID"),
                    @ApiResponse(responseCode = "401", description = "JWT Token 认证失败")
            }
    )
    @ApiOperationSupport(author = "于魏祎 yu_weiyi@outlook.com")
    public Result<String> logout() {

        log.debug("收到登出请求");
        String oldUid = logoutService.logout();
        return Result.success(oldUid);
    }
}
