package com.course.server.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 统一返回值类
 */
@Data
@Builder
public class ResponseDto<T>{

    private Boolean isSuccess = true;

    /**
     * 返回编码
     */
    private Integer code;


    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回内容
     */
    private T content;
}
