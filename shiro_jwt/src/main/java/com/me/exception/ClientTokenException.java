package com.me.exception;


import com.me.constants.CommonConstants;

/**
 * @Author:
 * @Date: 2018/4/28 16:19
 * @Description:
 */
public class ClientTokenException extends BaseException {
    public ClientTokenException(String message) {
        super(message, CommonConstants.EX_CLIENT_INVALID_CODE);
    }
}
