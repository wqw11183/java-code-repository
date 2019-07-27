package com.wqw.codelibrary.validation;

import com.wqw.codelibrary.validation.custom.BetweenValid;
import com.wqw.codelibrary.validation.custom.Default;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("检验实体")
public class ValidationEntity {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空",groups = {Default.class})
    private String userName;

    @ApiModelProperty("邮箱")
    @NotEmpty(message = "邮箱不能为空")
    @Email
    private String email;

    @ApiModelProperty("年龄")
    @Min(value = 0,message = "年龄不能小于1")
    @Max(value = 150,message = "年龄不能大于100")
    private int age;


    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("区间")
    @BetweenValid(start = 1,end = 100)
    private int between;

}
