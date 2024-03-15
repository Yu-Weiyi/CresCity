package pers.yuweiyi.crescity.service.cityservice.service;
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
 * @version 1.1
 * @since 2024.03.13
 */
public interface JwtService {

    /**
     * @Description  创建JWT令牌。
     * @param uid 账户UID。
     * @return String
     * @Author 于魏祎 Yu Weiyi
     */
    String buildToken(String uid);

    /**
     * @Description  缓存JWT令牌。
     * @param uid 账户UID。
     * @param token JWT令牌。
     * @return
     * @Author 于魏祎 Yu Weiyi
     */
    void createToken(String uid, String token);

    /**
     * @Description  删除JWT令牌。
     * @param uid 账户UID。
     * @return void
     * @Author 于魏祎 Yu Weiyi
     */
    void deleteToken(String uid);

    /**
     * @Description  查询JWT令牌。
     * @param uid 账户UID。
     * @return String
     * @Author 于魏祎 Yu Weiyi
     */
    String retrieveToken(String uid);

    /**
     * @Description  校验JWT令牌。
     * @param token 令牌。
     * @return String
     * @Author 于魏祎 Yu Weiyi
     */
    String verifyToken(String token);
}
