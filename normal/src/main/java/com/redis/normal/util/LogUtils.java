package com.redis.normal.util;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;

import java.util.UUID;

/**
 * 记录日志工具
 */
public class LogUtils {
    /**
     * 日志id载体
     */
    private static ThreadLocal<String> logsIdHolder = new ThreadLocal<String>();
    private LogUtils(){

    }
    /**
     * 日志标识格式
     */
    private static String FOR_MAT = "[%s]-[%s]-";

    /**
     * 初始化日志id
     *
     * @return String
     */
    public static String initLogsId() {
        String logsId = generateLogsId();
        logsIdHolder.set(logsId);
        return logsId;
    }

    /**
     * 初始化日志id
     *
     * @param serviceId 业务id
     * @return String
     */
    public static String initLogsId(String serviceId) {
        String logsId = String.format(FOR_MAT, generateLogsId(), serviceId);
        logsIdHolder.set(logsId);
        return logsId;
    }

    /**
     * 得到日志id，调用该方法时必须调用initLogsId方法
     *
     * @return String
     */
    public static String getLogsId() {
        return logsIdHolder.get();
    }

    /**
     * 得到带有业务ID的日志id,eg:[34234234afdafafafdaf]-[商超提单2.0]-
     *
     * @param serviceId 业务id
     * @return String
     */
    public static String getLogsId(String serviceId) {
        return String.format(FOR_MAT, getLogsId(), serviceId);
    }

    /**
     * 生成唯一字符串，根据uuid去掉-,多台机器重复几率很低，用于日志跟踪
     *
     * @return 日志id
     */
    private static String generateLogsId() {
        String uuid = UUID.randomUUID().toString();
        return uuid.substring(0, 8) + uuid.substring(9, 13) + uuid.substring(14, 18) + uuid.substring(19, 23) + uuid.substring(24);
    }

    /**
     * 记录接口的输入信息
     *
     * @param logsId 日志唯一标识
     * @param desc   调用描述
     * @param params 参数信息
     */
    public static void input(Logger log, Object logsId, String desc, Object... params) {
        log.info(logsId + "{}请求参数params={}", desc, JSON.toJSONString(params));
    }

    /**
     * 记录接口的输出信息
     *
     * @param log    记录器
     * @param logsId 日志唯一标识
     * @param desc   调用描述
     * @param result 返回结果
     */
    public static void output(Logger log, Object logsId, String desc, Object... result) {
        log.info(logsId + "{}返回结果result={}", desc, JSON.toJSONString(result));
    }

    /**
     * 记录日志信息
     *
     * @param log    记录器
     * @param logsId 日志唯一标识
     * @param desc   调用描述
     * @param info   日志信息
     */
    public static void info(Logger log, Object logsId, String desc, Object... info) {
        log.info(logsId + "{}记录信息info={}", desc, JSON.toJSONString(info));
    }

    /**
     * 记录错误信息
     *
     * @param log    记录器
     * @param logsId 日志唯一标识
     * @param desc   调用描述
     * @param data   数据
     */
    public static void error(Logger log, Object logsId, String desc, Object... data) {
        log.error(logsId + "{}发生错误error={}", desc, JSON.toJSONString(data));
    }

    /**
     * 记录接口异常信息
     *
     * @param log    记录器
     * @param logsId 日志唯一标识
     * @param desc   调用描述
     * @param t      异常信息
     */
    public static void error(Logger log, Object logsId, String desc, Throwable t) {
        log.error(logsId + desc + "发生异常exception=", t);
    }

    /**
     * 记录调试信息
     *
     * @param log    记录器
     * @param logsId 日志唯一标识
     * @param desc   调用描述
     * @param debug  debug信息
     */
    public static void debug(Logger log, Object logsId, String desc, Object debug) {
        log.debug(logsId + "{}调试信息debug={}", desc, JSON.toJSONString(debug));
    }

    /**
     * 清空threadlocal
     */
    public static void removeLogs() {
        logsIdHolder.remove();
    }

}
