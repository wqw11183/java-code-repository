package com.wqw.codelibrary.base;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
//对象可见性处理
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateObject {

    private String id;

    private String name;

    @Builder.Default//如果有默认值的处理
    private int age=1;

    public static void main(String[] args) {

        CreateObject createObject = new CreateObjectBuilder().id("123").name("wqw").build();
        System.out.println(createObject);

    }

}
