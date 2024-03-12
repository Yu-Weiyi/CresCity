package pers.yuweiyi.crescity.service.account.repository.impl;
/*
 * @file        AccountProfileReactiveRepositoryImpl
 * @brief       账户资料响应式存储器实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.12
 * @last_edit   2024.03.12
 */

import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pers.yuweiyi.crescity.service.account.pojo.dao.AccountProfileDao;
import pers.yuweiyi.crescity.service.account.repository.AccountProfileReactiveRepository;
import pers.yuweiyi.crescity.service.account.repository.mongo.AccountProfileReactiveMongoRepository;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Description: 账户资料响应式存储器实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.12
 */
@Repository
@Slf4j
public class AccountProfileReactiveRepositoryImpl implements AccountProfileReactiveRepository {

    @Autowired
    private AccountProfileReactiveMongoRepository accountProfileReactiveMongoRepository;

    /**
     * @param newUid 新账户uid。
     * @return void
     * @Description 新建文档。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public void create(String newUid) {
        accountProfileReactiveMongoRepository.save(new AccountProfileDao(newUid)).block();
        log.debug("新建文档。");
    }

    /**
     * @param uid      账户uid。
     * @param idCardNum 身份证号。
     * @param realName 真实（中文）姓名。
     * @param nickName （中文）网名。
     * @return void
     * @Description 当注册市民账户时，更新（初始化）文档。
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public void updateWhenRegisterTypeC(String uid, String idCardNum, String realName, String nickName) {
        AccountProfileDao accountProfileDao =  accountProfileReactiveMongoRepository.findByUid(uid).block();
        accountProfileDao.setDeleted(false);
        accountProfileDao.setAccountType("C");
        Map infoMap = new LinkedHashMap<String, Object>();
        infoMap.put("id_card_num", idCardNum);
        Map realNameMap = new LinkedHashMap<String, Object>();
        realNameMap.put("zh_CN", realName);
        Map nickNameMap = new LinkedHashMap<String, Object>();
        nickNameMap.put("zh_CN", nickName);
        infoMap.put("real_name", realNameMap);
        infoMap.put("nick_name", nickNameMap);
        accountProfileDao.setInfo(infoMap);
        accountProfileReactiveMongoRepository.save(accountProfileDao).block();
    }

    /**
     * @Description  查询存储_id。
     * @param uid 账户UID。
     * @return String _id
     * @Author 于魏祎 Yu Weiyi
     */
    ObjectId tetrieveIdByUid(String uid) {
        return accountProfileReactiveMongoRepository.findByUid(uid).block().get_id();
    }
}
