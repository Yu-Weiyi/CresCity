package pers.yuweiyi.crescity.service.account.controller;
/*
 * @file        AuthenticationController
 * @brief       请求认证控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.20
 * @last_edit   2024.03.20
 */

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.yuweiyi.crescity.service.account.context.BaseContext;
import pers.yuweiyi.crescity.service.account.pojo.result.Result;

/**
 * Description: 请求认证控制器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.20
 */
@RestController
@RequestMapping("/authentication")
@Tag(name = "请求认证接口", description = "请求认证接口")
@ApiSupport(author = "于魏祎 yu_weiyi@outlook.com")
@Slf4j
public class AuthenticationController {

    /**
     * @Description  请求认证。
     * @param jwtToken JWT Token
     * @return Result String 账户UID。
     * @Author 于魏祎 Yu Weiyi
     */
    @PostMapping
    @Operation(
            summary = "请求认证接口", description = "请求认证接口",
            responses = {
                    @ApiResponse(responseCode = "200-00000", description = "正常返回认证账户UID"),
                    @ApiResponse(responseCode = "401", description = "JWT Token 认证失败")
            }
    )
    @ApiOperationSupport(author = "于魏祎 yu_weiyi@outlook.com")
    public Result<String> authentication(@RequestBody String jwtToken) {

        log.debug("收到认证请求。");
        return Result.success(BaseContext.retrieveUid());
    }
}
