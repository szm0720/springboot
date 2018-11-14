package com.redis.normal.template;

import com.redis.normal.common.ICode;
import com.redis.normal.common.Result;

/**
 * 提交模板
 *
 */
public abstract class BaseInterfaceTemplate<I, O> implements IBaseInterfaceTemplate<I, O> {
    @Override
    public Result<O> submit(I data) throws Exception {
        //1.基础逻辑验证-返回错误码文案
        ICode basicCheckCode = basicCheck(data);
        if (!basicCheckCode.isExpect()) {
            return Result.create(basicCheckCode);
        }
        //业务校验-返回文案-校验数据
        Result businessCheck = businessCheck(data);
        if (!businessCheck.isExpect()) {
            return Result.create(businessCheck,businessCheck.getData());
        }
        //业务逻辑处理-返回文案-业务数据
        Result consume = consume(data);
        if (!consume.isExpect()) {
            return Result.create(consume,consume.getData());
        }
        //异步处理-无返回结果
        async(data);
        //返回处理结果
        return consume;
    }
    /**
     * 基础信息验证
     *
     * @param data 提交的数据
     * @return ICode
     */
    @Override
    public abstract ICode basicCheck(I data)throws Exception;
    /**
     * 业务校验
     *
     * @param data 提交的数据
     * @return ICode
     */
    @Override
    public abstract Result businessCheck(I data) throws Exception;
    /**
     * 资源消费
     *
     * @param data 提交的数据
     * @return ICode
     */
    @Override
    public abstract Result consume(I data) throws Exception;
    /**
     * 异步处理流程
     *
     * @param data 提交的数据
     */
    @Override
    public abstract void async(I data);
}
