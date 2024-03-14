package pers.yuweiyi.crescity.service.account.constant;
/*
 * @file        ExceptionConstant
 * @brief       异常常量。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.13
 */

/**
 * Description: 异常常量。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 0.2
 * @since 2024.03.09
 */
public class ExceptionConstant {

    //U0000

    //U0010 RegisterFailureException
    public static final String USER_REGISTER_FAILURE = "U0010" + ":" + "用户注册失败";
    public static final String USER_IDENTITY_VERIFICATION_FAILURE = "U0011" + ":" + "实名认证失败";
    public static final String USER_ACCOUNT_ALREADY_REGISTERED = "U0012" + ":" + "账户重复注册";

    //U0020 LoginFailureException
    public static final String USER_LOGIN_FAILURE = "U0020" + ":" + "用户登录失败";
    public static final String USER_LOGIN_WITH_INEXISTENT_UID = "U0021" + ":" + "登录账户不存在";
    public static final String USER_LOGIN_WITH_WRONG_PASSWORD = "U0022" + ":" + "登录密码错误";
}
