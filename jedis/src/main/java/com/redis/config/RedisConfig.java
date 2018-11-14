package com.redis.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;

@Configuration
@Slf4j
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String hostip;
    @Value("${spring.redis.port}")
    private Integer port;

    @Bean
    public ShardedJedisPool shardedJedisPool() {
        // 配置连接池
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        ArrayList<JedisShardInfo> arrayList = new ArrayList<>();
        arrayList.add(new JedisShardInfo(hostip, port));
        ShardedJedisPool shardedJedisPool = new ShardedJedisPool(jedisPoolConfig, arrayList);
        return shardedJedisPool;
    }
}