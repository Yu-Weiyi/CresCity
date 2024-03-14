package pers.yuweiyi.crescity.service.account.util;
/*
 * @file        BCryptUtil
 * @brief       BCrypt工具。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.13
 * @last_edit   2024.03.13
 */

import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

/**
 * Description: BCrypt工具。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.13
 */
@Component
@Slf4j
public class BCryptUtil {

    public static String hash(String password) {

        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean verify(String password, String passwordHash) {

        return BCrypt.checkpw(password, passwordHash);
    }
}
