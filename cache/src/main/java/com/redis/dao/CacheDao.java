package com.redis.dao;

import com.redis.mapper.SysUserMapper;
import com.redis.modal.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: shimingming
 * @create: 2018-10-24
 * @description:
 **/
@Repository
@Slf4j
@CacheConfig(cacheNames = {"myCache"})
public class CacheDao {

    @Resource
    SysUserMapper sysUserMapper;

    @Cacheable(value = "myCache",key = "#user.username")
    public List<SysUser> select(SysUser user) {

        List<SysUser> select = sysUserMapper.select(user);

        log.info("执行SQL,查询到:{}条数据",select.size());

        return select;
    }
}
