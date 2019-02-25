package com.seatig.quanaxy.common;

import java.io.Serializable;

import lombok.Data;

/**
 * 返回结果
 * @Description 
 * @author xianw
 * @time 2019年2月25日下午1:33:21
 * @version v1.0
 * @param <T>
 */
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int resultCode;
    private String message;
    private T data;

}
