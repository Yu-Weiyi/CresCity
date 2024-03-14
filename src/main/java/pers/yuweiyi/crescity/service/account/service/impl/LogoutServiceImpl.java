package pers.yuweiyi.crescity.service.account.service.impl;
/*
 * @file        LogoutServiceImpl
 * @brief       登出服务实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.yuweiyi.crescity.service.account.context.BaseContext;
import pers.yuweiyi.crescity.service.account.service.JwtService;
import pers.yuweiyi.crescity.service.account.service.LogoutService;

/**
 * Description: 登出服务实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.14
 */
@Service
@Slf4j
public class LogoutServiceImpl implements LogoutService {

    @Autowired
    private JwtService jwtService;

    /**
     * @return String 账户UID。
     * @Description 登出。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public String logout() {

        String uid = BaseContext.retrieveUid();
        jwtService.deleteToken(uid);
        return uid;
    }
}
