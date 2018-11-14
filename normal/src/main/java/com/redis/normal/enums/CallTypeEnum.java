package com.redis.normal.enums;

/**
 *
 */
public enum CallTypeEnum {
    CALL_FROM(1, "调用FROM"),
    CALL_TO(2, " 回调TO");

    private int code;
    private String desc;

    private CallTypeEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public static String getDescByCode(int code){
        for(CallTypeEnum refer : CallTypeEnum.values())
            if(code==refer.getCode())
                return refer.getDesc();
        return null;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
