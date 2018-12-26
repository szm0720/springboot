package com.me.io;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.function.LongToIntFunction;

/**
 * @author: shimingming
 * @create: 2018-11-29
 * @description: io测试
 **/
@Slf4j
public class ioTest {

    private static String s = "/Users/shishimei/Documents/GitHub/springboot/DataStructure/src/main/resources/a.txt";

    public static void main(String[] args) {

        try {
            new BufferedReader(new FileReader(s));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void inputstreamreader() {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(s));
            char read = (char)inputStreamReader.read();
            log.info("read的值是:{}",String.valueOf(read));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void filereader() {
        try {
            FileReader fileReader = new FileReader(s);
            char[] buf = new char[100];
            char read = (char) fileReader.read(buf, 0, buf.length);
            log.info("read的值是:{}", String.valueOf(buf));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void chararrayreaderio() {
        char[] c = new char[]{'a', 's', 'd', 'e'};
        CharArrayReader charArrayReader = new CharArrayReader(c);
        try {
            for (int i = 0; i < c.length; i++) {
                char read = (char) charArrayReader.read();
                log.info("read的值是:{}", String.valueOf(read));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void bufferedinputstream() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(s));
            for (int i = 0; i < s.length(); i++) {
                int read = bufferedInputStream.read();
                log.info("read的值是:{}", read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileinputstremio() {
        try {
            FileInputStream fileInputStream = new FileInputStream(s);
            for (int i = 0; i < s.length(); i++) {
                int read = fileInputStream.read();
                log.info("read的值是:{}", read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void byteArrayinputstream() {

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes());
        for (int i = 0; i < 10; i++) {
            int read = byteArrayInputStream.read();

            String s1 = Integer.toHexString(read);
            log.info("s1的值是:{}", s1);
        }
    }
}
