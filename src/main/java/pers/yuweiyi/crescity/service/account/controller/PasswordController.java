package pers.yuweiyi.crescity.service.account.controller;
/*
 * @file        PasswordController
 * @brief       账户密码修改控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.22
 * @last_edit   2024.03.22
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
import pers.yuweiyi.crescity.service.account.pojo.dto.PasswordChangeDto;
import pers.yuweiyi.crescity.service.account.pojo.result.Result;
import pers.yuweiyi.crescity.service.account.service.PasswordService;

/**
 * Description: 账户密码修改控制器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.22
 */
@RestController
@RequestMapping("/password")
@Tag(name = "账户密码接口", description = "账户密码接口")
@ApiSupport(author = "于魏祎 yu_weiyi@outlook.com")
@Slf4j
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    /**
     * @Description  账户密码修改接口。
     * @param passowrdChangeDto
     * @return
     * @Author 于魏祎 Yu Weiyi
     */
    @PostMapping("/change")
    @Operation(
            summary = "账户密码修改接口", description = "账户密码修改接口",
            responses = {
                    @ApiResponse(responseCode = "200-00000", description = "正常返回账户UID"),
                    @ApiResponse(responseCode = "200-U0022", description = "登录密码错误"),
                    @ApiResponse(responseCode = "401", description = "JWT Token 认证失败")
            }
    )
    @ApiOperationSupport(author = "于魏祎 yu_weiyi@outlook.com")
    public Result<String> change(@RequestBody PasswordChangeDto passowrdChangeDto) {

        log.debug("收到账户密码修改请求。");
        String uid = passwordService.change(passowrdChangeDto);
        return Result.success(uid);
    }
}
