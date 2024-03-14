package pers.yuweiyi.crescity.service.account.service.impl;
/*
 * @file        LoginServiceImpl
 * @brief       登录服务实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.yuweiyi.crescity.service.account.constant.ExceptionConstant;
import pers.yuweiyi.crescity.service.account.exception.LoginFailureException;
import pers.yuweiyi.crescity.service.account.mapper.AccountMapper;
import pers.yuweiyi.crescity.service.account.pojo.dto.LoginByUidDto;
import pers.yuweiyi.crescity.service.account.service.JwtService;
import pers.yuweiyi.crescity.service.account.service.LoginService;
import pers.yuweiyi.crescity.service.account.util.BCryptUtil;

/**
 * Description: 登录服务实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.13
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BCryptUtil bCryptUtil;

    /**
     * @param loginByUidDto
     * @return String
     * @Description 账号密码方式登录
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public String loginByUid(LoginByUidDto loginByUidDto) {

        boolean isVerified =  verify(loginByUidDto.getUid(), loginByUidDto.getPassword());
        if (isVerified) {
            String token = jwtService.createToken(loginByUidDto.getUid());
            jwtService.storeToken(loginByUidDto.getUid(), token);
            return token;
        }
        else {
            throw new LoginFailureException(ExceptionConstant.USER_LOGIN_FAILURE);
        }
    }

    /**
     * @Description  账号密码校验。
     * @param uid 账户UID。
     * @param password 明文密码。
     * @return boolean
     * @Author 于魏祎 Yu Weiyi
     */
    boolean verify(String uid, String password) {

        boolean isExisting = accountMapper.retrieveExistence(uid);
        if (isExisting) {
            String passwordHash =  accountMapper.retrievePasswordHash(uid);
            boolean isVerified = bCryptUtil.verify(password, passwordHash);
            if (isVerified) {
                return isVerified;
            }
            else {
                throw new LoginFailureException(ExceptionConstant.USER_LOGIN_WITH_WRONG_PASSWORD);
            }
        }
        else {
            throw new LoginFailureException(ExceptionConstant.USER_LOGIN_WITH_INEXISTENT_UID);
        }
    }
}
