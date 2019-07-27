package com.wqw.codelibrary.validation;

import com.wqw.codelibrary.common.ApiResult;
import com.wqw.codelibrary.validation.custom.Default;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Email;

@RestController
@RequestMapping("/validation")
@Api(value = "/validation", description = "校验")
public class ValidationController {

    @GetMapping("/entity/test")
    @ApiOperation("对象提交验证")
    public ApiResult testEntityValidation(@Validated(Default.class) ValidationEntity validationEntity, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            for(ObjectError objectError : bindingResult.getAllErrors()){
                return ApiResult.fail(objectError.getDefaultMessage());
            }

        }
        return ApiResult.success("");
    }

    @GetMapping("/param/test/{userId}")
    @ApiOperation("参数请求验证")
    public ApiResult testParamValidation(
            @Validated @Email @PathVariable String userId
    ){

        return ApiResult.success("");
    }

}
