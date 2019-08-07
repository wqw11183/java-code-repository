package com.wqw.codelibrary.redis;

import com.wqw.codelibrary.common.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
@Api(value = "/redis", description = "Redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @GetMapping("/redis/test")
    @ApiOperation("redis简单测试")
    public ApiResult testRedis(){

        redisTemplate.opsForValue().set("test-redis","redis test success");
        String s = (String) redisTemplate.opsForValue().get("test-redis");
        return ApiResult.success(s);
    }

}
