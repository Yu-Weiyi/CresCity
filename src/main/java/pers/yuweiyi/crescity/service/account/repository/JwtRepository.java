package pers.yuweiyi.crescity.service.account.repository;
/*
 * @file        JwtRepository
 * @brief       JWT存储器接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import reactor.core.publisher.Mono;

/**
 * Description: JWT存储器接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.13
 */
public interface JwtRepository {

    /**
     * @Description  创建JWT缓存。
     * @param uid 账户UID。
     * @param token JWT令牌。
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    void create(String uid, String token);

    /**
     * @Description  查询JWT缓存。
     * @param uid 账户UID。
     * @return Mono String
     * @Author 于魏祎 Yu Weiyi
     */
    Mono<String> retrieve(String uid);

    /**
     * @Description  删除JWT缓存。
     * @param uid 账户UID。
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    void delete(String uid);
}
