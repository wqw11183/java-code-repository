package com.wqw.codelibrary.validation.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BetweenValidator implements ConstraintValidator<BetweenValid,Integer> {

    private int start;

    private int end;

    @Override
    public void initialize(BetweenValid constraintAnnotation) {

        this.start = constraintAnnotation.start();
        this.end = constraintAnnotation.end();

    }

    @Override
    public boolean isValid(Integer o, ConstraintValidatorContext constraintValidatorContext) {

        if (o == null) {
            return true;
        }
        if(o >= start && o<= end ){
            return true;
        }else{
            //禁用默认的message的值
            constraintValidatorContext.disableDefaultConstraintViolation();
            //重新添加错误提示语句
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("不得小于"+start+"或大于"+end).addConstraintViolation();
            return false;
        }


    }
}
