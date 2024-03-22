package pers.yuweiyi.crescity.service.account.service.impl;
/*
 * @file        PasswordServiceImpl
 * @brief       账户密码服务实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.22
 * @last_edit   2024.03.22
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.yuweiyi.crescity.service.account.constant.ExceptionConstant;
import pers.yuweiyi.crescity.service.account.context.BaseContext;
import pers.yuweiyi.crescity.service.account.exception.LoginFailureException;
import pers.yuweiyi.crescity.service.account.mapper.AccountMapper;
import pers.yuweiyi.crescity.service.account.pojo.dao.AccountDao;
import pers.yuweiyi.crescity.service.account.pojo.dto.PasswordChangeDto;
import pers.yuweiyi.crescity.service.account.service.LogoutService;
import pers.yuweiyi.crescity.service.account.service.PasswordService;
import pers.yuweiyi.crescity.service.account.util.BCryptUtil;

/**
 * Description: 账户密码服务实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.22
 */
@Service
@Slf4j
public class PasswordServiceImpl implements PasswordService {

    @Autowired
    private LogoutService logoutService;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private BCryptUtil bCryptUtil;

    /**
     * @param passwordChangeDto
     * @return String 账户UID
     * @Description 账户密码修改。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public String change(PasswordChangeDto passwordChangeDto) {

        boolean isVerified = verify(BaseContext.retrieveUid(), passwordChangeDto.getOldPassword());
        if (isVerified) {
            String newPasswordHash = bCryptUtil.hash(passwordChangeDto.getNewPassword());
            accountMapper.updatePasswordHash(new AccountDao(BaseContext.retrieveUid(), newPasswordHash));
            logoutService.logout();
        }
        return BaseContext.retrieveUid();
    }

    /**
     * @Description  账号密码校验。
     * @param uid 账户UID。
     * @param password 明文密码。
     * @return boolean
     * @Author 于魏祎 Yu Weiyi
     */
    public boolean verify(String uid, String password) {

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
