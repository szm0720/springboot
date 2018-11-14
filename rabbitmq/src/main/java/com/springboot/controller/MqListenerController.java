package com.springboot.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author: shimingming
 * @create: 2018-10-23
 * @description:
 **/

@Component
@Slf4j
public class MqListenerController {

    @RabbitHandler
    @RabbitListener(queues = "ha.firmiana.proxy.test")
    public void combyte(byte[] bytes) {

        String jsonStr="";
        try {
            jsonStr=byteArrayToStr(bytes);
            //字节转换
            log.info("com.byte 接收到参数:{}",jsonStr);
            log.info(" over");
        } catch (Exception e) {
            log.error(" error,{},传入参数:{}",e.toString(),jsonStr);
        }
    }


    /**
     * byte[] to String
     * @param byteArray
     * @return
     */
    private  String byteArrayToStr(byte[] byteArray) {
        if (byteArray == null) {
            return null;
        }
        String str = new String(byteArray);
        return str;
    }

//    @RabbitHandler
//    @RabbitListener(queues = "com.string")
//    @RabbitListener(bindings ={@QueueBinding(value = @Queue(value = "q5",durable = "true"),
//            exchange =@Exchange(value = "zhihao.miao.exchange",durable = "true"),key = "welcome")})
    public void handleMessage(Message message){

        System.out.println(message.getMessageProperties());
        System.out.println(new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = "ha.firmiana.proxy.clue")
    public void clue(byte[] bytes) {

        String jsonStr="";
        try {
            jsonStr=byteArrayToStr(bytes);
            //字节转换
            log.info("接收到参数:{}",jsonStr);
            log.info(" over");
        } catch (Exception e) {
            log.error(" error,{},传入参数:{}",e.toString(),jsonStr);
        }
    }

}
