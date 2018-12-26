package com.me.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author: shimingming
 * @create: 2018-12-25
 * @description:
 **/
@Configuration
@EnableRedisHttpSession
public class HttpSessionConfig {

}
