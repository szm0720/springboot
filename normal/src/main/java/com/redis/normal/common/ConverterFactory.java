package com.redis.normal.common;

/**
 * 转换器工厂类
 */
public class ConverterFactory {
    /**
     * fromlog转换器
     */
    private static final FormLogConverter formLogConverter = new FormLogConverter();
    /**
     * tolog转换器
     */
    private static final ToLogConverter toLogConverter = new ToLogConverter();



    /**
     * @return formLogConverter
     * @param
     */
    public static FormLogConverter createFromConverter() {
        return formLogConverter;
    }
    /**
     * @return toLogConverter
     * @param
     */
    public static ToLogConverter createToConverter() {
        return toLogConverter;
    }

}
