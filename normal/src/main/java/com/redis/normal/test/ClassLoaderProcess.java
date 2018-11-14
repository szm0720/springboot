package com.redis.normal.test;

/**
 * @author: shimingming
 * @create: 2018-11-08
 * @description:
 **/
public class ClassLoaderProcess {
    public static void main(String[] args) {
        System.out.println(Singleton.count_1);
        System.out.println(Singleton.count_2);
    }
}

class Singleton {
    private static Singleton singleton = new Singleton();
    public static int count_1;
    public static int count_2 = 0;

    static {
        count_1++;
        count_2++;
    }

    private Singleton() {
        count_1++;
        count_2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}