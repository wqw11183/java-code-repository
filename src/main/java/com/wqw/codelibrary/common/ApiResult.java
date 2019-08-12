package com.wqw.codelibrary.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("返回对象")
public class ApiResult<T> {

    @ApiModelProperty("返回码")
    private int code;

    @ApiModelProperty("返回信息")
    private String msg;

    @ApiModelProperty("返回数据")
    private T data;

    public static ApiResult success(Object o) {
        ApiResult<Object> apiResult = new ApiResult<>();
        apiResult.setCode(0);
        apiResult.setMsg("请求成功");
        apiResult.setData(o);
        return apiResult;
    }


    public static ApiResult fail(String msg) {
        ApiResult<Object> apiResult = new ApiResult<>();
        apiResult.setCode(-1);
        apiResult.setMsg(msg);
        return apiResult;
    }

}
