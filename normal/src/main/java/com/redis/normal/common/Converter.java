package com.redis.normal.common;
/**
 * 装换器接口
 * @param <S> 来源类型
 * @param <T> 目标类型
 */
public interface Converter<S, T> {
    /**
     * 转换
     *
     * @param source 来源
     * @return 目标
     * @throws Exception 转换异常
     */
    T convert(S source, T target) throws Exception;
}
