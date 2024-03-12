package pers.yuweiyi.crescity.service.account.webclient.impl;
/*
 * @file        IdentityVerificationWebclientImpl
 * @brief       实名认证网络客户端实现。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pers.yuweiyi.crescity.service.account.pojo.dto.IdentityVerificationDto;
import pers.yuweiyi.crescity.service.account.pojo.result.Result;
import pers.yuweiyi.crescity.service.account.util.WebClientUtil;
import pers.yuweiyi.crescity.service.account.webclient.IdentityVerificationWebclient;

/**
 * Description: 实名认证网络客户端实现。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 0.1
 * @since 2024.03.09
 */
@Component
@Slf4j
public class IdentityVerificationWebclientImpl implements IdentityVerificationWebclient {

    @Autowired
    WebClientUtil webClientUtil;

    /**
     * @Description  调用身份认证API。
     * @param idCardNum 身份证号
     * @param realName 真实姓名
     * @return boolean
     * @Author 于魏祎 Yu Weiyi
     */
    @Override
    public boolean verify(String idCardNum, String realName) {

        //TEMP 暂时写死
        WebClient.ResponseSpec response =  webClientUtil.request(HttpMethod.POST,
                "http://8.137.62.188:30001/api/third_party/identity_verification/verify",
                MediaType.APPLICATION_JSON,
                10000,
                new IdentityVerificationDto(idCardNum, realName)
        );
        Result result =  response.bodyToMono(Result.class).block();
        return result.isSucceed();
    }
}
