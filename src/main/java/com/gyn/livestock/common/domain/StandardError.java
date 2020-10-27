package com.gyn.livestock.common.domain;

/**
 * @author zhangjun.zyk
 * @version 1.0.0
 * @date 2015/1/26 11:23
 * @descrpiton
 * 定义标准异常,需提供三类基准信息
 * 1. 错误类型
 * 2. 错误码
 * 3. 错误描述
 */
public interface StandardError {

    /**
     * 返回错误类型,可以为null
     * @return
     */
    String getType();

    /**
     * 返回错误码
     * @return
     */
    String getCode();

    /**
     * 返回错误描述
     * @return
     */
    String getDescription();
}