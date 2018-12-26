package com.me.threadExecutors;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: shimingming
 * @create: 2018-12-13
 * @description:
 **/
public class ScheduledExecutorTest {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

        System.out.println("的值是：---" + simpleDateFormat.format(new Date()) + "，当前方法=ScheduledExecutorTest.main()");


        for (int i = 0; i < 30; i++) {

            scheduledExecutorService.schedule(new one(i), 0, TimeUnit.SECONDS);
        }
    }

}


class one implements Runnable {

    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    int i;

    one(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println("的值是：---" + simpleDateFormat.format(new Date()) + "-----" + i + "，当前方法=ScheduledExecutorTest.main()");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
