package com.me.modal.vo;

import lombok.Data;

/**
 * @author: shimingming
 * @create: 2018-10-29
 * @description:
 **/
@Data
public class VerificationTokenVo {
    private boolean flag;

    @Override
    public String toString() {
        return "{" +
                "flag:" + flag +
                '}';
    }
}
