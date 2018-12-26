package com.me.controller;

import com.redis.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: shimingming
 * @create: 2018-10-18
 * @description:
 **/
@RestController
public class TestController {
    @Autowired
    RedisUtil redisUtil;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        String key = "test";
        String value = "this is value";
        boolean b = redisUtil.hasKey(key);
        if (!b) {
            redisUtil.set(key, value);
        }
        return "ok";
    }
}
