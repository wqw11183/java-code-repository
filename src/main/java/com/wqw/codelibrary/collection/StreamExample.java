package com.wqw.codelibrary.collection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Java Stream 用法例子
 */

public class StreamExample {

    /**
     * 创建流的方式
     */
    public static void createStream(){

        //第一种
        Stream stream = Stream.of("a", "b", "c");
        //第二种
        String [] strArray = new String[] {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        //第三种
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();

    }


}
