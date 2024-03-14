package pers.yuweiyi.crescity.service.account.service;
/*
 * @file        LoginService
 * @brief       登录服务接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import pers.yuweiyi.crescity.service.account.pojo.dto.LoginByUidDto;

/**
 * Description: 登录服务接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.13
 */
public interface LoginService {

    /**
     * @Description  账号密码方式登录
     * @param loginByUidDto
     * @return String
     * @Author 于魏祎 Yu Weiyi
     */
    String loginByUid(LoginByUidDto loginByUidDto);
}
