package pers.yuweiyi.crescity.service.account.service;
/*
 * @file        JwtService
 * @brief       JWT服务接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

/**
 * Description: JWT服务接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.13
 */
public interface JwtService {

    /**
     * @Description  创建JWT令牌。
     * @param uid 账户UID。
     * @return String
     * @Author 于魏祎 Yu Weiyi
     */
    String createToken(String uid);

    /**
     * @Description  缓存JWT令牌。。
     * @param uid 账户UID。
     * @param token JWT令牌。
     * @return
     * @Author 于魏祎 Yu Weiyi
     */
    void storeToken(String uid, String token);
}
