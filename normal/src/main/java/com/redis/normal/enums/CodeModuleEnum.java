package com.redis.normal.enums;

import com.redis.normal.common.ICodeMsg;

/**
 * 码值对应的模块枚举
 *
 */
public enum CodeModuleEnum implements ICodeMsg {
    FROMLOG("11", "调用日志"),
    TOLOG("12", "回调日志"),
    APP("13", "应用管理"),
    PROJECT("14", "项目管理"),
    SUB_API("15", "订阅管理"),
    API("16", "API管理"),
    USER("17", "登录管理"),
    OPERATOR("18", "操作记录"),
    CALLBACK("19", "回调重试"),
    OPENAPI("20", "API对接");
    /**
     * 构造函数
     *
     * @param code 码值
     * @param msg  描述
     */
    CodeModuleEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 码值
     */
    private final String code;
    /**
     * 描述信息
     */
    private final String msg;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }
}
