package com.ay.entity;

import lombok.Data;

import java.util.TreeMap;

/**
 * @author WuDa
 * @data 2023/5/4
 **/
@Data
public class RestBean<T> {
    private int status;
    private boolean success;
    private T message;

    private RestBean(int status,boolean success,T message){
        this.status = status;
        this.success = success;
        this.message = message;
    }

    public static <T> RestBean<T> success(){
        return new RestBean<>(200, true,null);
    }

    public static <T> RestBean<T> success(T data){
        return new RestBean<>(200, true,data);
    }

    public static <T> RestBean<T> failure(int status){
        return new RestBean<>(status,false,null);
    }

    public static <T> RestBean<T> failure(int status, T data){
        return new RestBean<>(status,false,data);
    }
}
