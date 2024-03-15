package pers.yuweiyi.crescity.service.account.controller;
/*
 * @file        RegisterController
 * @brief       账户注册控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
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
import pers.yuweiyi.crescity.service.account.pojo.dto.RegisterTypeCDto;
import pers.yuweiyi.crescity.service.account.pojo.result.Result;
import pers.yuweiyi.crescity.service.account.service.RegisterService;

/**
 * Description: 账户注册控制器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.2
 * @since 2024.03.09
 */
@RestController
@RequestMapping("/register")
@Tag(name = "账户注册接口", description = "账户注册接口")
@ApiSupport(author = "于魏祎 yu_weiyi@outlook.com")
@Slf4j
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * @Description  公民账户注册接口。
     * @param registerTypeCDto
     * @return Result String
     * @Author 于魏祎 Yu Weiyi
     */
    @PostMapping("/type-c")
    @Operation(
            summary = "公民类型账户注册接口", description = "公民类型账户注册接口",
            responses = {
                    @ApiResponse(responseCode = "200-00000", description = "正常返回新注册的账户UID"),
                    @ApiResponse(responseCode = "200-U0011", description = "实名认证失败"),
                    @ApiResponse(responseCode = "200-U0012", description = "账户重复注册")
            }
    )
    @ApiOperationSupport(author = "于魏祎 yu_weiyi@outlook.com")
    public Result<String> registerTypeC(@RequestBody RegisterTypeCDto registerTypeCDto) {

        log.debug("收到注册请求。");
        String uid = registerService.registerTypeC(registerTypeCDto);
        return Result.success(uid);
    }
}
