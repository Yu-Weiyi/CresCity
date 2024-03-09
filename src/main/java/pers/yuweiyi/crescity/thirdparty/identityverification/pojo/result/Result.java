package pers.yuweiyi.crescity.thirdparty.identityverification.pojo.result;
/*
 * @file        Result
 * @brief       结果对象。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.08
 * @last_edit   2024.03.08
 */

import lombok.Data;

import java.io.Serializable;

/**
 * Description: 结果对象。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.08
 */
@Data
public class Result<T> implements Serializable {

    private String code;
    private String msg;
    private T data;

    public static <T> Result<T> success() {
        Result<T> newResult = new Result<T>();
        newResult.code = "00000";
        return  newResult;
    }

    public static <T> Result<T> success(T dataObject) {
        Result<T> newResult = new Result<T>();
        newResult.code = "00000";
        newResult.data = dataObject;
        return newResult;
    }

    public static <T> Result<T> error(String code, String msg) {
        Result<T> newResult = new Result<T>();
        newResult.code = code;
        newResult.msg = msg;
        return newResult;
    }

    public static <T> Result<T> error(String code, String msg, T dataObject) {
        Result<T> newResult = new Result<T>();
        newResult.code = code;
        newResult.msg = msg;
        newResult.data = dataObject;
        return newResult;
    }

    public boolean isSucceed() {
        return this.code.equals("00000");
    }
}
