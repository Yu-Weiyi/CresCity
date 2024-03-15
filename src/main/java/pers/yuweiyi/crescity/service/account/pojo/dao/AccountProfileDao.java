package pers.yuweiyi.crescity.service.account.pojo.dao;
/*
 * @file        AccountProfileDao
 * @brief       账户资料数据访问对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.11
 * @last_edit   2024.03.11
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Map;

/**
 * Description: 账户资料数据访问对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.1
 * @since 2024.03.11
 */
@Collation("account_profile")
@Document(collection = "account_profile")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountProfileDao {

    @Id
    @Field("_id")
    private ObjectId _id;
    @Field("is_deleted")
    private boolean isDeleted;
    @Indexed
    @Field("pk_uid")
    private String uid;
    @Field("account_type")
    private String accountType;
    @Field("bind")
    private Map bind;
    @Field("info")
    private Map info;

    /**
     * @Description  构造方法。
     * @param uid 账户UID。
     * @return AccountProfileDao
     * @Author 于魏祎 Yu Weiyi
     */
    public AccountProfileDao(String uid) {

        this.isDeleted = false;
        this.uid = uid;
    }
}
