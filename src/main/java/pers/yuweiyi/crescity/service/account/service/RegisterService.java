package pers.yuweiyi.crescity.service.account.service;
/*
 * @file        RegisterService
 * @brief       注册服务接口。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import pers.yuweiyi.crescity.service.account.pojo.dto.RegisterTypeCDto;

/**
 * Description: 注册服务接口。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.0
 * @since 2024.03.09
 */
public interface RegisterService {

    /**
     * @Description  注册公民账户。
     * @param registerTypeCDto
     * @return String
     * @Author 于魏祎 Yu Weiyi
     */
    String registerTypeC(RegisterTypeCDto registerTypeCDto);
}
