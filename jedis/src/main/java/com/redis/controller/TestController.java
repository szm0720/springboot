package com.redis.controller;

import com.redis.two.JedisUtil;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: shimingming
 * @create: 2018-10-26
 * @description: 测试
 **/
@RestController
@Import(value = {JedisUtil.class})
public class TestController {

    @RequestMapping("test01")
    public String test01() {

        JedisUtil jedisUtil = JedisUtil.getInstance();
        JedisUtil.Strings strings = jedisUtil.new Strings();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String format = simpleDateFormat.format(new Date());

        strings.set("time", format);
        System.out.println("-----" + strings.get("time"));

        return strings.get("time");
    }
}
