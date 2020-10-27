package com.gyn.livestock.common.domain;

/**
 * @version 1.0.0
 * @author: zhangyk
 * @date: 2017/8/18 21:40
 * @descrpiton: 标准异常消息
 */
public class StandardException extends RuntimeException implements StandardError {

    private String type;
    private String code;
    private String description;

    public StandardException(){

    }

    public StandardException(StandardError error,String description){
        this.type = error.getType();
        this.code = error.getCode();
        this.description = description;
    }

    public StandardException(String type,String code,String description){
        this.type = type;
        this.code = code;
        this.description = description;
    }

    @Override
    public String getType() {
        return type;
    }

    public StandardException setType(String type) {
        this.type = type;
        return this;
    }

    @Override
    public String getCode() {
        return code;
    }

    public StandardException setCode(String code) {
        this.code = code;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public StandardException setDescription(String description) {
        this.description = description;
        return this;
    }

    public String toString(){
        return "{type:"+type+",code:"+code+",description:"+description+"}";
    }

    public String getMessage(){
        return this.toString();
    }
}