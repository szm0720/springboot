package com.redis.normal.common;

/**
 * 码值和文案接口
 *
 */
public interface ICodeMsg {
    /**
     * 获取code值
     *
     * @return String
     */
    String getCode();

    /**
     * 获取文案
     *
     * @return String
     */
    String getMsg();
}
