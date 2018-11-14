package com.redis.normal.util;


import org.springframework.util.DigestUtils;

import java.security.MessageDigest;

/**
 * MD5通用类
 *
 * @author: shimingming
 * @create: 2018-11-01
 * @description:
 **/
public class MD5Utils {

    private static final String hexDigIts[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "com.redis.normal.a", "com.redis.normal.b", "c", "d", "e", "f"};

    /**
     * MD5加密
     * @param origin 字符
     * @param charsetname 编码
     * @return
     * @desc java自带jar工具MessageDigest实现
     */
    public static String MD5Encode(String origin, String charsetname) {
        String resultString = null;
        try {
            resultString = new String(origin);
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (null == charsetname || "".equals(charsetname)) {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes()));
            } else {
                resultString = byteArrayToHexString(md.digest(resultString.getBytes(charsetname)));
            }
        } catch (Exception e) {
        }
        return resultString;
    }


    public static String byteArrayToHexString(byte b[]) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    public static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigIts[d1] + hexDigIts[d2];
    }

    public static void main(String[] args) {
        String password = "starry12345";
        String password2 = MD5Utils.MD5Encode(password,"utf8");
        System.out.println(password2);


        /**
         * spring自带的工具DigestUtils实现
         * */
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
        System.out.println(md5DigestAsHex);


    }

}