package com.redis.normal.modal.vo;

import com.redis.normal.common.ICode;
import com.redis.normal.common.ICodeMsg;
import com.redis.normal.enums.CodeEnum;

/**
 * 返回码提示信息VO
 *
 *
 */
public class CodeMsgVo implements ICode {


    /**
     * 返回码
     */
    private final String code;
    /**
     * 文案
     */
    private final String msg;


    /**
     * 构造函数
     *
     * @param iCodeMsg 码值文案接口
     * @return CodeMsgVo
     */
    public static CodeMsgVo create(ICodeMsg iCodeMsg) {
        return new CodeMsgVo(iCodeMsg.getCode(), iCodeMsg.getMsg());
    }

    /**
     * 自定义构造
     *
     * @param code 返回码
     * @param msg  文案
     * @return CodeMsgVo
     */
    public static CodeMsgVo create(String code, String msg) {
        return new CodeMsgVo(code, msg);
    }

    /**
     * 自定义构造
     *
     * @param code 返回码
     * @param msg  文案
     */
    public CodeMsgVo(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 期望成功
     *
     * @return ture:符合期望；false:不符合期望
     */
    @Override
    public boolean isExpect() {
        return CodeEnum.OK.equals(getCode());
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public boolean isTransfer() {
        return CodeEnum.TRANSFER.equals(getCode());
    }



}
