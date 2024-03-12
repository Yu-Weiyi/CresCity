package pers.yuweiyi.crescity.service.account.pojo.result;
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

    /**
     * @Description  成功结果静态构造器。
     * @param <T> 数据类型。
     * @return Result T
     * @Author 于魏祎 Yu Weiyi
     */
    public static <T> Result<T> success() {
        Result<T> newResult = new Result<T>();
        newResult.code = "00000";
        return  newResult;
    }

    /**
     * @Description  成功结果静态构造器。
     * @param <T> 数据类型。
     * @param dataObject 携带数据。
     * @return Result T
     * @Author 于魏祎 Yu Weiyi
     */
    public static <T> Result<T> success(T dataObject) {
        Result<T> newResult = new Result<T>();
        newResult.code = "00000";
        newResult.data = dataObject;
        return newResult;
    }

    /**
     * @Description  错误结果静态构造器。
     * @param <T> 数据类型。
     * @param code 错误码。
     * @param msg 错误信息。
     * @return Result T
     * @Author 于魏祎 Yu Weiyi
     */
    public static <T> Result<T> error(String code, String msg) {
        Result<T> newResult = new Result<T>();
        newResult.code = code;
        newResult.msg = msg;
        return newResult;
    }

    /**
     * @Description  错误结果静态构造器。
     * @param <T> 数据类型。
     * @param code 错误码。
     * @param msg 错误信息。
     * @param dataObject 携带数据。
     * @return Result T
     * @Author 于魏祎 Yu Weiyi
     */
    public static <T> Result<T> error(String code, String msg, T dataObject) {
        Result<T> newResult = new Result<T>();
        newResult.code = code;
        newResult.msg = msg;
        newResult.data = dataObject;
        return newResult;
    }

    /**
     * @Description  判定结果是否成功。
     * @return boolean
     * @Author 于魏祎 Yu Weiyi
     */
    public boolean isSucceed() {
        return this.code.equals("00000");
    }
}
