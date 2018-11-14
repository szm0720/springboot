package com.redis.normal.template;


import com.redis.normal.common.ICode;
import com.redis.normal.common.Result;

/**
 * 通用提交模板接口
 *
 */
public interface IBaseInterfaceTemplate<I,O> extends IBaseInterface<I, O> {
    /**
     * 提交
     *
     * @param data 提交的数据
     * @return Result   提交结果
     * @throws Exception
     */
    Result<O> submit(I data) throws Exception;
    /**
     * 基础信息验证
     *
     * @param data 提交的数据
     * @return ICode
     */
    ICode basicCheck(I data)throws Exception;
    /**
     * 业务校验
     *
     * @param data 提交的数据
     * @return Result
     */
    Result businessCheck(I data) throws Exception;
    /**
     * 资源消费
     *
     * @param data 提交的数据
     * @return Result
     */
    Result consume(I data) throws Exception;
    /**
     * 异步处理流程
     *
     * @param data 提交的数据
     */
    void async(I data);
}
