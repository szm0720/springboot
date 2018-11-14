package com.redis.normal.config;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 调用日志Mapper
 */
public interface CoreMapper<T>  extends Mapper<T>,MySqlMapper<T> {
}

