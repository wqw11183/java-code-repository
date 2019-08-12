package com.wqw.codelibrary.util;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.Objects;

/**
 * Map与Object互相转化
 */
public class MapObjectUtil {

    /**
     * map转为Object
     * @param map
     * @param beanClass
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T mapToObject(Map map, Class<T> beanClass) throws Exception {

        if (Objects.isNull(map) || map.isEmpty()){
            return null;
        }

        T obj = beanClass.newInstance();

        BeanUtils.populate(obj, map);

        return obj;
    }

    /**
     * Object 转为 map
     * @param obj
     * @return
     */
    public static Map<?, ?> objectToMap(Object obj) {

        if (Objects.isNull(obj)){
            return null;
        }

        return new BeanMap(obj);
    }

}
