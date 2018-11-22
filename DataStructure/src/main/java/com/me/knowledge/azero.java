package com.me.knowledge;

import sun.util.calendar.CalendarDate;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.DateFormat;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: shimingming
 * @create: 2018-11-22
 * @description: 序
 **/
public class azero {


    /**
     * https://www.cnblogs.com/skywang12345/archive/2013/06/14/index.html
     * <p>
     * 知识点
     * <p>
     * 01. Java 随机数
     * <p>
     * 02, Java hashCode() 和 equals()的若干问题解答
     * <p>
     * 03, Java 中 Comparable 和 Comparator 比较
     * <p>
     * 04. Java Annotation认知(包括框架图、详细介绍、示例说明)
     * <p>
     * 05. Java引用总结--StrongReference、SoftReference、WeakReference、PhantomReference
     */


    public static void main(String[] args) throws FileNotFoundException {
        /**系列专题的目录*/
        /** 01. Java String系列      (共3篇)*/
        new String();
        new StringBuffer();
        new StringBuilder();
//        CharSequence();
        /**02. Java异常系列         (共3篇)*/

        /** 03. Java 时间日期系列 (共7篇)*/
       /* Calendar;
        Date;
        DateFormat;
        Locale;
        TimeZone();*/
        /**  04. java io系列              (共26篇)*/
        new FileInputStream("");
        /** 05, Java 集合系列        (共18篇)*/
        new ArrayList();
        /**06. Java 多线程系列  juc  (共43篇)*/
        new ReentrantLock();
    }


}
