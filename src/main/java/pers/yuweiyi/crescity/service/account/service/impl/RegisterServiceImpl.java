package pers.yuweiyi.crescity.service.account.service.impl;
/*
 * @file        RegisterServiceImpl
 * @brief       注册服务实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.yuweiyi.crescity.service.account.constant.ExceptionConstant;
import pers.yuweiyi.crescity.service.account.exception.AccountAlreadyRegisteredException;
import pers.yuweiyi.crescity.service.account.exception.IdentityVerificationFailureException;
import pers.yuweiyi.crescity.service.account.mapper.AccountMapper;
import pers.yuweiyi.crescity.service.account.pojo.dao.AccountDao;
import pers.yuweiyi.crescity.service.account.pojo.dto.RegisterTypeCDto;
import pers.yuweiyi.crescity.service.account.repository.AccountProfileReactiveRepository;
import pers.yuweiyi.crescity.service.account.service.RegisterService;
import pers.yuweiyi.crescity.service.account.webclient.IdentityVerificationWebclient;

/**
 * Description: 注册服务实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.09
 */
@Service
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    AccountProfileReactiveRepository accountProfileReactiveRepository;
    @Autowired
    IdentityVerificationWebclient identityVerificationWebclient;

    /**
     * @Description  注册公民账户。
     * @param registerTypeCDto
     * @return java.lang.String
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public String registerTypeC(RegisterTypeCDto registerTypeCDto) {

        String idCardNum = registerTypeCDto.getIdCardNum();
        String realName = registerTypeCDto.getRealName();
        String nickName = registerTypeCDto.getNickName();
        String passwordHash = registerTypeCDto.getPasswordHash();

        boolean isValid = identityVerificationWebclient.verify(idCardNum, realName);
        if (isValid) {
            log.debug("实名认证成功。");
            String newUid = "C" + idCardNum;
            boolean isExisting = accountMapper.retrieveExistence(newUid);
            if (isExisting) {//重复注册
                throw new AccountAlreadyRegisteredException(ExceptionConstant.USER_ACCOUNT_ALREADY_REGISTERED);
            }
            else {
                log.debug("新账户注册。");
                initializeNewAccount(newUid, passwordHash);
                accountProfileReactiveRepository.updateWhenRegisterTypeC(newUid, idCardNum, realName, nickName);
                log.debug("新账户注册成功。");
                return newUid;
            }
        }
        else {//实名认证失败
            throw new IdentityVerificationFailureException(ExceptionConstant.USER_IDENTITY_VERIFICATION_FAILURE);
        }
    }

    /**
     * @Description  初始化账户相关数据库。
     * @param newUid 新账户UID
     * @param passwordHash 加密密码
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    void initializeNewAccount(String newUid, String passwordHash) {

        accountMapper.create(new AccountDao(newUid, passwordHash));
        accountProfileReactiveRepository.create(newUid);
    }
}
