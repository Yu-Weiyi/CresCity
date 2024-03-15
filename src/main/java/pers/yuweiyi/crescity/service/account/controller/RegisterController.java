package pers.yuweiyi.crescity.service.account.controller;
/*
 * @file        RegisterController
 * @brief       账户注册控制器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import io.swagger.v3.oas.annotations.Operation;
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
 * @version 1.1
 * @since 2024.03.09
 */
@RestController
@RequestMapping("/register")
@Tag(name = "用户注册相关接口")
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
    @Operation(summary = "公民账户注册接口")
    public Result<String> registerTypeC(@RequestBody RegisterTypeCDto registerTypeCDto) {

        log.debug("收到注册请求。");
        String uid = registerService.registerTypeC(registerTypeCDto);
        return Result.success(uid);
    }
}
