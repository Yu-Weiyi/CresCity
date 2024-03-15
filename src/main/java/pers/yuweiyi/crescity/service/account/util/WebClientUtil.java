package pers.yuweiyi.crescity.service.account.util;
/*
 * @file        WebClientUtil
 * @brief       网络客户端工具。
 * @author      于魏祎 Yu Weiyi
 * @email       yu_weiyi@outlook.com
 * @date        2024.03.09
 * @last_edit   2024.03.09
 */

import io.netty.channel.ChannelOption;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import pers.yuweiyi.crescity.service.account.configuration.WebClientConfiguration;
import reactor.netty.http.client.HttpClient;
import reactor.netty.http.client.HttpClientRequest;

import java.io.Serializable;
import java.time.Duration;

/**
 * Description: 网络客户端工具。
 *
 * @author 于魏祎 Yu Weiyi
 * @version 1.2
 * @since 2024.03.09
 */
@Component
@Data
@Slf4j
public class WebClientUtil {

    private WebClientConfiguration webClientConfiguration;

    private final WebClient webClient;

    private MediaType mediaType = MediaType.APPLICATION_JSON;

    /**
     * @Description  构造方法。
     * @return WebClientUtil
     * @Author 于魏祎 Yu Weiyi
     */
    public WebClientUtil(WebClientConfiguration webClientConfiguration) {

        this.webClient = WebClient.builder()
                //set timeout
                .clientConnector(new ReactorClientHttpConnector(
                                HttpClient.create()
                                        //set connection timeout
                                        .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, webClientConfiguration.getConnectionTimeout())
                                        //set response timeout
                                        .responseTimeout(Duration.ofMillis(webClientConfiguration.getResponseTimeout()))
                        )
                )
                .build();
        this.webClientConfiguration = webClientConfiguration;
    }

    /**
     * @Description  发起HTTP请求。
     * @param httpMethod HTTP方法。
     * @param uri 请求目标URL地址。
     * @param mediaType 数据类型。
     * @param timeout 超时时间。
     * @param dtoData 数据传输对象。
     * @return WebClient.ResponseSpec
     * @Author 于魏祎 Yu Weiyi
     */
    public WebClient.ResponseSpec request(HttpMethod httpMethod, String uri, MediaType mediaType, int timeout, Serializable dtoData) {

        return webClient
                .method(httpMethod)
                .uri(uri)
                .contentType(mediaType)
                .accept(mediaType)
                .bodyValue(dtoData)
                .httpRequest(clientHttpRequest -> {
                    HttpClientRequest httpClientRequest = clientHttpRequest.getNativeRequest();
                    httpClientRequest.responseTimeout(Duration.ofMillis(timeout));
                })
                .retrieve();
    }

    /**
     * @Description  发起HTTP请求。
     * @param httpMethod HTTP方法。
     * @param host 请求目标IP地址。
     * @param port 请求目标端口。
     * @param path 请求目标路径。
     * @param mediaType 数据类型。
     * @param timeout 超时时间。
     * @param pathData 路径携带数据。
     * @param dtoData 数据传输对象。
     * @return WebClient.ResponseSpec
     * @Author 于魏祎 Yu Weiyi
     */
    public WebClient.ResponseSpec request(HttpMethod httpMethod, String host, String port, String path, MediaType mediaType, int timeout, String pathData, Serializable dtoData) {

        String uri = "http://" + host + ":" + port + path + pathData;
        return request(httpMethod, uri, mediaType, timeout, dtoData);
    }

    /**
     * @Description  发起平台内部HTTP请求。
     * @param httpMethod HTTP方法。
     * @param path 请求目标路径。
     * @param pathData 路径携带数据。
     * @param dtoData 数据传输对象。
     * @return WebClient.ResponseSpec
     * @Author 于魏祎 Yu Weiyi
     */
    public WebClient.ResponseSpec request(HttpMethod httpMethod, String path, String pathData, Serializable dtoData) {

        return request(httpMethod, webClientConfiguration.getHost(), webClientConfiguration.getPort(), path, mediaType, webClientConfiguration.getResponseTimeout(), pathData, dtoData);
    }
}
