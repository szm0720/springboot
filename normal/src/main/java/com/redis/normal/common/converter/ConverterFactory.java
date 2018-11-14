package com.redis.normal.common.converter;

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
     * @param
     * @return formLogConverter
     */
    public static FormLogConverter createFromConverter() {
        return formLogConverter;
    }

    /**
     * @param
     * @return toLogConverter
     */
    public static ToLogConverter createToConverter() {
        return toLogConverter;
    }

}
