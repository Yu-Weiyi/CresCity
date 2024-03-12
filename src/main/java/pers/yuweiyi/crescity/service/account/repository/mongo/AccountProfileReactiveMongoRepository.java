package pers.yuweiyi.crescity.service.account.repository.mongo;
/*
 * @file        AccountProfileReactiveMongoRepository
 * @brief       账户资料响应式MongoDB存储器接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.12
 * @last_edit   2024.03.12
 */

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import pers.yuweiyi.crescity.service.account.pojo.dao.AccountProfileDao;
import reactor.core.publisher.Mono;

/**
 * Description: 账户资料响应式MongoDB存储器接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.12
 */
public interface AccountProfileReactiveMongoRepository extends ReactiveMongoRepository<AccountProfileDao, ObjectId> {

    /**
     * @Description  根据账户UID查询文档。
     * @param uid 账户UID。
     * @return Mono AccountProfileDao
     * @Author 于魏祎 Yu Weiyi
     */
    Mono<AccountProfileDao> findByUid(String uid);
}
