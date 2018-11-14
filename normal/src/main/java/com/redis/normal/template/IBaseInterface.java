package com.redis.normal.template;


import com.redis.normal.common.Result;

/**
 * 通用提交接口
 *
 */
public interface IBaseInterface<I, O> {
    /**
     * 提交
     *
     * @param data 提交数据
     * @return Result   提交结果
     * @throws Exception
     */
    Result<O> submit(I data) throws Exception;

}
