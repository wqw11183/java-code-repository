package com.wqw.codelibrary.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
//对象可见性处理
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String name;

    private Long id;

    private Integer age;

}
