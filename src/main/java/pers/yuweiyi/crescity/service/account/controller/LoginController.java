package pers.yuweiyi.crescity.service.account.controller;
/*
 * @file        LoginController
 * @brief       账户登录控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.12
 * @last_edit   2024.03.12
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yuweiyi.crescity.service.account.pojo.dto.LoginByUidDto;
import pers.yuweiyi.crescity.service.account.pojo.result.Result;
import pers.yuweiyi.crescity.service.account.service.LoginService;

/**
 * Description: 账户登录控制器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.12
 */
@RestController
@RequestMapping("/api/service/login")
@Api(tags = "用户登录相关接口")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * @Description  账户密码方式登录接口。
     * @param loginByUidDto
     * @return Result String
     * @Author 于魏祎 Yu Weiyi
     */
    @PostMapping("/by_uid")
    @ApiOperation("账户密码方式登录接口")
    public Result<String> loginByUid(@RequestBody LoginByUidDto loginByUidDto) {

        log.debug("收到登录请求。");

        String token = loginService.loginByUid(loginByUidDto);
        return Result.success(token);
    }
}
