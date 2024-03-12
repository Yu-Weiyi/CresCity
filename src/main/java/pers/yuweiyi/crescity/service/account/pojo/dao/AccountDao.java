package pers.yuweiyi.crescity.service.account.pojo.dao;
/*
 * @file        AccountDao
 * @brief       账户数据访问对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.10
 * @last_edit   2024.03.10
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: 账户数据访问对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.10
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountDao {

    private String _id;
    private boolean isDeleted;
    private String uid;
    private String passwordHash;

    /**
     * @Description  构造方法。
     * @param uid 账户uid。
     * @param passwordHash 账户密码哈希。
     * @return AccountDao
     * @Author 于魏祎 Yu Weiyi
     */
    public AccountDao(String uid, String passwordHash) {
        this._id = null;
        this.isDeleted = false;
        this.uid = uid;
        this.passwordHash = passwordHash;
    }
}
