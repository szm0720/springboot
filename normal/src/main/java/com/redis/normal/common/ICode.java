package com.redis.normal.common;

/**
 * 流程及的返回码及文案，实现该类
 *
 */
public interface ICode extends ICodeMsg {
    /**
     * 全局约定的特殊码值
     * CODE_OK:0，操作成功码值
     * CODE_ERROR:-1 操作失败码值
     * CODE_TRANSFER：10000  透传的码值
     * PARAMS_ERROR 缺少参数
     */
    String  CODE_OK = "0",
            CODE_ERROR = "-1",
            CODE_TRANSFER = "10000",
            PARAMS_ERROR = "-2",
            OVER_LIMIT = "-3";
    /**
     * 默认的文案格式及默认文案
     */
    String  DEFAULT_FORMAT = "%s[%s]",
            DEFAULT_MSG = "提交繁忙中,请稍后重试!";

    /**
     * 是否为期望结果
     *
     * @return true:是；false：否
     */
    boolean isExpect();

    /**
     * 是否为透传的文案
     *
     * @return true:是；false：否
     */
    boolean isTransfer();


}
