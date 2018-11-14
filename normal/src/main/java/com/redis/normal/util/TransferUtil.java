package com.redis.normal.util;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: shimingming
 * @create: 2018-10-24
 * @description: 把json 转换成 对象
 **/
public class TransferUtil {
    public static <T> T transfer(Object text, Class<T> clazz) {
        return JSONObject.parseObject(JSONObject.toJSONString(text), clazz);
    }
}
