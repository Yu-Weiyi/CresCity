package pers.yuweiyi.crescity.service.account.controller;
/*
 * @file        LogoutController
 * @brief       账户登出控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * @version 1.0
 * @since 2024.03.14
 */
@RestController
@RequestMapping("/api/service/logout")
@Api(tags = "用户登出相关接口")
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
    @ApiOperation("登出接口")
    public Result<String> logout() {

        log.debug("收到登出请求");

        String oldUid = logoutService.logout();
        return Result.success(oldUid);
    }
}
