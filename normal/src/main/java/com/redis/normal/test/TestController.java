package com.redis.normal.test;

import com.redis.normal.annotation.BusinessLog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: shimingming
 * @create: 2018-10-29
 * @description:
 **/
@RestController
public class TestController {

    @RequestMapping(value = "/com/redis/normal/test",method = RequestMethod.GET)
    @BusinessLog(logInfo = "测试，打印时间")
    public String getTime(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String format = simpleDateFormat.format(new Date());
        return format;
    }


}
