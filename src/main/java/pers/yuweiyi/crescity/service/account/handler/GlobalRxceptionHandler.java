package pers.yuweiyi.crescity.service.account.handler;
/*
 * @file        GlobalRxceptionHandler
 * @brief       全局异常处理器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.yuweiyi.crescity.service.account.exception.BaseException;
import pers.yuweiyi.crescity.service.account.pojo.result.Result;

/**
 * Description: 全局异常处理器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.09
 */
@RestControllerAdvice
@Slf4j
public class GlobalRxceptionHandler {

    /**
     * @Description  处理全局异常。
     * @param ex 异常
     * @return pers.yuweiyi.crescity.service.account.pojo.result.Result
     * @Author 于魏祎 Yu Weiyi
     */
    @ExceptionHandler
    public Result handleException(BaseException ex) {

        String error = ex.getMessage();
        log.error("异常：{}", error);
        return Result.error(error.substring(0, 5), error.substring(6));//XCODE:说明
    }
}
