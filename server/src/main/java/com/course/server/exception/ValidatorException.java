package com.course.server.exception;
/**
* 校验异常
* @author Winston.Wang
* @date 2020/10/15
* @version 1.0
**/
public class ValidatorException extends RuntimeException{

    public ValidatorException(String message) {
        super(message);
    }
}
