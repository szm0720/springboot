package com.redis.config;

/**
 * @author: shimingming
 * @create: 2018-10-10
 * @description: Mapper
 **/


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CoreMapper<T>  extends Mapper<T>,MySqlMapper<T> {
}

