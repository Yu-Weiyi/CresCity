package pers.yuweiyi.crescity.service.account.controller;
/*
 * @file        LoginController
 * @brief       账户登录控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.12
 * @last_edit   2024.03.12
 */

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
 * @version 1.2
 * @since 2024.03.12
 */
@RestController
@RequestMapping("/login")
@Tag(name = "账户登录接口", description = "账户登录接口")
@ApiSupport(author = "于魏祎 yu_weiyi@outlook.com")
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
    @PostMapping("/by-uid")
    @Operation(
            summary = "账户密码方式登录接口", description = "账户密码方式登录接口",
            responses = {
                    @ApiResponse(responseCode = "200-00000", description = "正常返回 JWT Token"),
                    @ApiResponse(responseCode = "200-U0020", description = "用户登录失败"),
                    @ApiResponse(responseCode = "200-U0021", description = "登录账户不存在"),
                    @ApiResponse(responseCode = "200-U0022", description = "登录密码错误")
            }
    )
    @ApiOperationSupport(author = "于魏祎 yu_weiyi@outlook.com")
    public Result<String> loginByUid(@RequestBody LoginByUidDto loginByUidDto) {

        log.debug("收到登录请求。");
        String token = loginService.loginByUid(loginByUidDto);
        return Result.success(token);
    }
}
