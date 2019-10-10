package com.wqw.codelibrary.http;

import com.wqw.codelibrary.common.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rest-template")
@Api(value = "/rest-template", description = "http请求器")
@Slf4j
public class RestTemplateController {

    @Resource(name = "urlConnection")
    private RestTemplate urlConnectionRestTemplate;

    @Resource(name ="httpClient")
    private RestTemplate httpClientRestTemplate;

    @Resource(name ="oKHttp3")
    private RestTemplate oKHttp3RestTemplate;

    @GetMapping("/test")
    @ApiOperation("测试各类实现的rest-template")
    public ApiResult testRestTemplate(){

        String url = "http://www.baidu.com";

        log.info("urlConnectionRestTemplate请求结果为:{}",urlConnectionRestTemplate.getForEntity(url,String.class));

        log.info("httpClientRestTemplate请求结果为:{}",httpClientRestTemplate.getForEntity(url,String.class));

        log.info("oKHttp3RestTemplate请求结果为:{}",oKHttp3RestTemplate.getForEntity(url,String.class));

        return ApiResult.success("");
    }

}
