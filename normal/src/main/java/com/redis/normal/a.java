package com.redis.normal;

import java.util.Arrays;

/**
 * @author: shimingming
 * @create: 2018-10-25
 * @description:
 **/
public class a {

    public static void main(String[] args) {

        String carType = "7";

        String[] split = carType.split(",");
        Long[] alongs = new Long[split.length];
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            alongs[i] = Long.valueOf(s);
        }

        String s = Arrays.toString(alongs);
        System.out.println(s);
    }
}
