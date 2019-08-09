package com.wqw.codelibrary.redis;

import com.wqw.codelibrary.common.ApiResult;
import com.wqw.codelibrary.common.User;
import com.wqw.codelibrary.util.MapObjectUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redis")
@Api(value = "/redis", description = "Redis")
@Slf4j
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


    @GetMapping("/redis/hash")
    @ApiOperation("redis hash测试")
    public ApiResult testHash() throws Exception {

        User user = User.builder().id(11223L).age(18).name("wqw").build();
        Map<?,?> map = MapObjectUtil.objectToMap(user);
        map = new HashMap<>(map);
        map.remove("class");
        String key = "student-info-" + user.getId();
        redisTemplate.opsForHash().putAll(key,map);
        map = redisTemplate.opsForHash().entries(key);
        user = MapObjectUtil.mapToObject(map,User.class);
        log.info((String) redisTemplate.opsForHash().get(key,"name"));

        return ApiResult.success(user);
    }

}
