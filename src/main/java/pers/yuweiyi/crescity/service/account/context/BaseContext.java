package pers.yuweiyi.crescity.service.account.context;
/*
 * @file        BaseContext
 * @brief       基础上下文。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.14
 * @last_edit   2024.03.14
 */

/**
 * Description: 基础上下文。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.14
 */
public class BaseContext {

    public static ThreadLocal<String> threadLocalUid = new ThreadLocal<>();

    public static void createUid(String uid) {

        threadLocalUid.set(uid);
    }

    public static String retrieveUid() {

        return threadLocalUid.get();
    }

    public static void deleteUid() {

        threadLocalUid.remove();
    }
}
