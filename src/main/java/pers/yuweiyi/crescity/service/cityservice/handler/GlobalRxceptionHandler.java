package pers.yuweiyi.crescity.service.cityservice.handler;
/*
 * @file        GlobalRxceptionHandler
 * @brief       全局异常处理器。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.13
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.yuweiyi.crescity.service.cityservice.exception.BaseException;
import pers.yuweiyi.crescity.service.cityservice.pojo.result.Result;

/**
 * Description: 全局异常处理器。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
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
        log.warn("异常：{}", error);
        return Result.error(error);//XCODE:说明
    }
}
