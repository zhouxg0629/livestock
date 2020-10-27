package com.gyn.livestock.common.domain;


import lombok.Data;

/**
 * @version 1.0.0
 * @author: zhangyk
 * @date: 2017/8/18 21:40
 * @descrpiton: 封装执行结果
 */
@Data
public class JsonResult<T> {

    private boolean success;

    private T data;

    private String code;

    private String message;

    public JsonResult() {
        this.code = "200";
        this.success = true;
    }

    public JsonResult(String message) {
        this.success = false;
        this.code = "500";
        this.message = message;
    }

    public JsonResult(String code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }
}
