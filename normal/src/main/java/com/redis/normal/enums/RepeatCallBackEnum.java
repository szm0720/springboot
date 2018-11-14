package com.redis.normal.enums;

public enum RepeatCallBackEnum {
    SUCCESS(0, "成功"),
    FAIL(1, "失败");

    private int code;
    private String desc;

    private RepeatCallBackEnum(int code, String desc){
        this.code = code;
        this.desc = desc;
    }
    public static String getDescByCode(int code){
        for(RepeatCallBackEnum refer : RepeatCallBackEnum.values())
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
