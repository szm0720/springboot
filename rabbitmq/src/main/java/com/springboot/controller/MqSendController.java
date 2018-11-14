package com.springboot.controller;

/**
 * @author: shimingming
 * @create: 2018-10-23
 * @description: mq消息发送
 **/

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class MqSendController {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @ResponseBody
    @RequestMapping(value = "/mqbyte", method = RequestMethod.POST)
    public String mq(@RequestBody String content) {

        log.info("模拟发送消息 ,内容:{}", content);

        rabbitTemplate.convertAndSend("firmiana", "ha.firmiana.proxy.test.nihao", content.getBytes());
        return "模拟发送 ok";

    }

    @ResponseBody
    @RequestMapping(value = "/mqString", method = RequestMethod.POST)
    public String mqString(@RequestBody String content) {

        log.info("模拟发送消息 ,内容:{}", content);

        rabbitTemplate.convertAndSend("firmiana", "ha.firmiana.proxy.test.nihao", content);
        return "模拟发送 ok";

    }


}


