package com.redis.normal.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: shimingming
 * @create: 2018-10-31
 * @description:
 **/
@Slf4j
public class b {

    public static void main(String[] args) {

//        getDataFromMqMessage();


//        System.out.println(System.currentTimeMillis() / 1000);

//        String lo="1544080102000";
//
//
//
//        long time = Long.parseLong(lo);
//        Date date = new Date(time);
//        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = sd.format(date);
//        System.out.println(format);


//        BigDecimal allPrice = new BigDecimal(10.09);
//        allPrice= allPrice.multiply(new BigDecimal(100)).setScale(0,BigDecimal.ROUND_HALF_UP);
//        log.info(allPrice.toString());
//
//        double v = new BigDecimal(3).multiply(new BigDecimal(1000)).doubleValue();
//        log.info(String.valueOf(v));



//        BigDecimal bigDecimal = new BigDecimal("0.201111");
//        BigDecimal bigDecimal1 = new BigDecimal(0.201111);
//
//        System.out.println("123");
//
//
//        BigDecimal order_total_price = new BigDecimal("0.23456").multiply(new BigDecimal(100)).setScale(0);
//        BigDecimal order_total_price2 = new BigDecimal("0.20").multiply(new BigDecimal(-100)).setScale(0);
//        BigDecimal order_total_price3 = new BigDecimal("0.20").multiply(new BigDecimal("100")).setScale(0);
//        BigDecimal order_total_price4 = new BigDecimal("0.20").multiply(new BigDecimal("-100")).setScale(0);
//
//        BigDecimal allPrice= new BigDecimal(0.01).multiply(new BigDecimal(-100)).setScale(0);//扣费是负数，单位为分
//        BigDecimal allPrice2= new BigDecimal("0.01").multiply(new BigDecimal(-100)).setScale(0);//扣费是负数，单位为分
////        BigDecimal allPrice3= new BigDecimal(-0.01).multiply(new BigDecimal(-100)).setScale(0);//扣费是负数，单位为分
//        BigDecimal allPrice4= new BigDecimal("-0.01").multiply(new BigDecimal(-100)).setScale(0);//扣费是负数，单位为分

//        log.info(allPrice.toString());

    }

    private static void getDataFromMqMessage() {
        String mq="{\"msgid\":\"rabbit.send.5bd6c5bb58d451540801979\",\"data\":{\"InsuredOrderId\":\"1540801979296974016\",\"InsuredPerson\":\"\\u5317\\u4eac\\u53f8\\u673a1\",\"InsuredSex\":1,\"InsuredIdCard\":\"142625197711111111\",\"InsuredPhone\":\"11088881110\",\"AdcId\":1,\"InsuredArea\":\"\\u5317\\u4eac\\u7ba1\\u7406\\u533a\",\"InsuredType\":8,\"DriverId\":2001123,\"DriverName\":\"\\u5317\\u4eac\\u53f8\\u673a1\",\"DriverSex\":1,\"DriverIdCard\":\"142625197711111111\",\"DriverPhone\":\"11088881110\",\"Source\":\"yunniao\"}}\n";
        JSONObject jsonObject = JSON.parseObject(mq);
        String data = jsonObject.getString("data");
        System.out.println(data);
    }
}
