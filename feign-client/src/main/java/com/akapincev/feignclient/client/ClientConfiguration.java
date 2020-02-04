package com.akapincev.feignclient.client;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;

public class ClientConfiguration {

    @Value("${feign.client.logging.level}")
    private String loggingLevel;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return (RequestTemplate requestTemplate) ->
                requestTemplate.header(HttpHeaders.ACCEPT_ENCODING, "identity");
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        switch (loggingLevel) {
        case "BASIC":
            return Logger.Level.BASIC;
        case "HEADERS":
            return Logger.Level.HEADERS;
        case "FULL":
            return Logger.Level.FULL;
        default:
            return Logger.Level.NONE;
        }
    }
}
