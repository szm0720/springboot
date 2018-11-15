package com.me.util;

import java.io.Serializable;

/**
 * @Author:
 * @Date: 2018/5/16 16:47
 * @Description:
 */
public class IResult<T> implements Serializable {
    private final T data;

    public IResult(T data) {
        this.data = data;
    }

    public <T> T getData() {

        return (T) this.data;
    }


}
