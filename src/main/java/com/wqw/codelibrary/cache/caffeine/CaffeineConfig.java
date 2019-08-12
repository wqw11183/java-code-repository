package com.wqw.codelibrary.cache.caffeine;


import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.RemovalCause;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CaffeineConfig {

    public static Cache<String, Object> caffeineCache;

    static {
        caffeineCache = Caffeine.newBuilder()
                .initialCapacity(10)//初始化大小
                .maximumSize(10)//最大长度
                .recordStats()//开启统计
                .expireAfterWrite(4, TimeUnit.SECONDS)//淘汰策略
                .removalListener((@Nullable Object key, @Nullable Object value, @NonNull RemovalCause cause)->{
                    log.info("key:" + key + ",value:" + value + ",删除原因:" + cause);
                })//移除监听
                .build();
    }

    private static Object getValue(String s) {

        String value = "xx"+s;
        return value;

    }


    public static void main(String[] args) throws InterruptedException {

        for(int i = 0; i < 1000 ;i++){
            String xx = (String)caffeineCache.get(i+"", (String key) -> getValue(key));
        }
        TimeUnit.SECONDS.sleep(5);
        caffeineCache.cleanUp();
        log.info(caffeineCache.asMap().toString());
        log.info(caffeineCache.stats().toString());


    }
}
