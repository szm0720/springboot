package com.redis.normal.common;
import java.io.Serializable;

/**
 * 流程结果接口
 * .
 */
public class Result<T> implements ICode, Serializable {
    /**
     * 异常的返回
     */
    public static final Result ERROR = create(CodeEnum.ERROR);
    /**
     * 码值
     */
    private  String code;
    /**
     * 文案
     */
    private  String msg;
    /**
     * 详情
     */
    private String detail;
    /**
     * 数据
     */
    private T data;
    /**
     * 无参构造函数
     *
     */
    public Result() {
    }
    /**
     * 构造函数
     *
     * @param code 码值
     * @param msg  文案
     */
    private Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 静态构造
     *
     * @param code 码值
     * @param msg  文案
     * @return Result
     */
    public static Result create(String code, String msg) {
        return new Result(code, msg);
    }

    /**
     * 静态构造
     *
     * @param iCodeMsg ICodeMsg实现
     * @return Result
     */
    public static Result create(ICodeMsg iCodeMsg) {
        return new Result(iCodeMsg.getCode(), iCodeMsg.getMsg());
    }
    /**
     * 静态构造
     *
     * @param iCodeMsg ICodeMsg实现
     * @param data   数据
     * @param <T>      数据泛型
     * @return Result
     */
    public static <T> Result create(ICodeMsg iCodeMsg, T data) {
        Result result = new Result(iCodeMsg.getCode(), iCodeMsg.getMsg());
        result.setData(data);
        return result;
    }

    /**
     * 静态构造
     *
     * @param code   码值
     * @param msg    文案
     * @param detail 详情
     * @return Result
     */
    public static Result create(String code, String msg, String detail) {
        Result result = new Result(code, msg);
        result.setDetail(detail);
        return result;
    }

    /**
     * 静态构造
     *
     * @param code   码值
     * @param msg    文案
     * @param detail 详情
     * @param data 数据
     * @param <T>    数据泛型
     * @return Result
     */
    public static <T> Result create(String code, String msg, String detail, T data) {
        Result result = new Result(code, msg);
        result.setDetail(detail);
        result.setData(data);
        return result;
    }

    /**
     * 静态构造
     *
     * @param code   码值
     * @param msg    文案
     * @param data 数据
     * @param <T>    数据泛型
     * @return Result
     */
    public static <T> Result create(String code, String msg, T data) {
        Result result = new Result(code, msg);
        result.setData(data);
        return result;
    }

    /**
     * 静态构造
     *
     * @param data 数据
     * @param <T>    数据泛型
     * @return Result
     */
    public static <T> Result success(T data) {
        Result result = new Result(CodeEnum.OK.getCode(), CodeEnum.OK.getMsg());
        result.setData(data);
        return result;
    }
    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public boolean isExpect() {
        return CodeEnum.OK.equals(this.code);
    }

    @Override
    public boolean isTransfer() {
        return false;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
