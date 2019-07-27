package com.wqw.codelibrary.http;


import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    @Bean("urlConnection")
    public RestTemplate urlConnectionRestTemplate(){
        SimpleClientHttpRequestFactory sf = new SimpleClientHttpRequestFactory();
        sf.setConnectTimeout(1000);
        sf.setReadTimeout(1000);
        RestTemplate restTemplate = new RestTemplate(sf);
        return restTemplate;
    }

    @Bean("httpClient")
    public RestTemplate httpClientRestTemplate(){
        HttpComponentsClientHttpRequestFactory hf = new HttpComponentsClientHttpRequestFactory();
        hf.setConnectTimeout(1000);
        hf.setReadTimeout(1000);
        RestTemplate restTemplate = new RestTemplate(hf);
        return restTemplate;
    }

    @Bean("oKHttp3")
    public RestTemplate oKHttp3RestTemplate(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10,TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .connectionPool(new ConnectionPool(20, 5, TimeUnit.MINUTES))
                .build();
        OkHttp3ClientHttpRequestFactory okf = new OkHttp3ClientHttpRequestFactory(okHttpClient);
        RestTemplate restTemplate = new RestTemplate(okf);
        return restTemplate;
    }

}
