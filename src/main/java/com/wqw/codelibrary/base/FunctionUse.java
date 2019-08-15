package com.wqw.codelibrary.base;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

@Data
class TestMap<K, V> {

    public Map<K,V> map = new HashMap<>();

    public Set<K> set = new HashSet<>();

    public V get(K key,Function<? super K, ? extends V> function) {
        V v = map.get(key);
        if(Objects.isNull(v)){
            v = function.apply(key);
            map.put(key,v);
            set.add(key);
        }
        return v;
    }

}

@Slf4j
public class FunctionUse{

    private static String getValue(String key){
        return "value";
    }


    public static void main(String[] args) {

        TestMap<String,String> t = new TestMap<>();
        t.get("key",key -> getValue("key"));
        log.info(t.map.toString());
        log.info(t.set.toString());

    }

}


