package com.redis.normal.common;
/**
 * 交易码枚举值
 *
 */
public enum CodeEnum implements ICode {
    /**
     * ************************* 全局的码值begin************************************
     */
    OK(ICode.CODE_OK, "成功", "操作成功"),
    ERROR(ICode.CODE_ERROR, formate(ICode.CODE_ERROR, ICode.DEFAULT_MSG), "操作失败"),
    TRANSFER(ICode.CODE_TRANSFER, ICode.DEFAULT_MSG, "透传文案"),
    PARAMS(ICode.PARAMS_ERROR, "系统繁忙", "缺少参数"),
    OVERLIMIT(ICode.OVER_LIMIT, ICode.DEFAULT_MSG, "请求已被限流"),
    /**************************全局的码值 end*************************************/
    /**
     * ***********************FromLog相关码begin*********************************
     */
     FROMLOG_PARAM_ERROR(CodeModuleEnum.FROMLOG, "00", ICode.DEFAULT_MSG, "FromLog参数校验失败"),
     FROMLOG_SQL_ERROR(CodeModuleEnum.FROMLOG, "01", "FromLog插入数据库失败", "FromLog插入数据库失败"),
     FROMLOG_SYSTEM_ERROR(CodeModuleEnum.FROMLOG, "02", "FromLog系统异常", "FromLog系统异常"),
     TOLOG_PARAM_ERROR(CodeModuleEnum.TOLOG, "00", "ToLog参数校验失败", "ToLog参数校验失败"),
     TOLOG_SQL_ERROR(CodeModuleEnum.TOLOG, "01", "ToLog插入数据库失败", "ToLog插入数据库失败"),
     TOLOG_SYSTEM_ERROR(CodeModuleEnum.TOLOG, "02", "ToLog系统异常", "ToLog系统异常"),
     LOG_CALLBACK_ERROR(CodeModuleEnum.CALLBACK, "01", "回调重试异常", "回调重试异常"),
    /**************************FromLog相关码 end***********************************/
    /**
     * ***********************运营平台相关码begin*********************************
     */
     LOING_USER_EMPTY(CodeModuleEnum.USER, "01", "用户名或密码为空", "用户名或密码为空"),
     LOGIN_PASSWORD_ERROR(CodeModuleEnum.USER, "02", "用户名或密码错误", "用户名或密码错误"),
    USER_SQL_ERROR(CodeModuleEnum.USER, "03", "User操作数据库失败", "User插入数据库失败"),
    USER_SYSTEM_ERROR(CodeModuleEnum.USER, "04", "User系统异常", "User系统异常"),
    LOING_USER_LOGIN(CodeModuleEnum.USER, "05", "token-intercept-failure", "token登录拦截失败"),
    LOING_SESSION_LOGIN(CodeModuleEnum.USER, "06", "SESSION过期请重新登录", "SESSION过期请重新登录"),

    APP_SQL_EMPTY(CodeModuleEnum.APP, "01", "查询结果为空", "查询结果为空"),
    APP_SQL_ERROR(CodeModuleEnum.APP, "02", "操作数据库失败", "操作数据库失败"),
    APP_SYSTEM_ERROR(CodeModuleEnum.APP, "03", "App系统异常", "App系统异常"),
    APP_PARAMS_ERROR(CodeModuleEnum.APP, "04", "输入参数为空", "输入参数为空"),
    APP_APPKEY_ERROR(CodeModuleEnum.APP, "05", "APPKEY生成有误", "APPKEY生成有误"),
    APP_APPKEY_EXIST(CodeModuleEnum.APP, "06", "APPKEY已经存在", "APPKEY已经存在"),
    APP_SOURCENAME_EXIST(CodeModuleEnum.APP, "06", "source_name已经存在", "source_name已经存在"),
    APP_CUSTOMERID_EXIST(CodeModuleEnum.APP, "07", "客户编号已经存在", "客户编号已经存在"),

    /**
     * ***********************运营平台相关码end*********************************
     */
    /**

     * ***********************MQ相关码begin*********************************
     */
    MQ_SYSTEM_ERROR(CodeModuleEnum.OPENAPI, "00","MQ消费异常", "MQ消费异常"),
    AUTH_PARAM_EMPTY(CodeModuleEnum.OPENAPI, "01","标准认证参数为空", "标准认证参数为空"),
    AUTH_NO_AUTHORITY(CodeModuleEnum.OPENAPI, "02","没有API调用权限", "没有API调用权限"),
    AUTH_APPKEY_ERROR(CodeModuleEnum.OPENAPI, "03","查询APPKEY异常", "查询APPKEY异常"),
    AUTH_MD5_ERROR(CodeModuleEnum.OPENAPI, "04","加密有误", "加密有误"),

    GATEWAY_SK_EMPTY(CodeModuleEnum.OPENAPI, "05","Gateway sk or appkey is empty", "Gateway sk or appkey is empty"),
    GATEWAY_PARAM_ERROR(CodeModuleEnum.OPENAPI, "06","Parameter resolution exception", "Parameter resolution exception"),

    EGNING_JSON_ERROR(CodeModuleEnum.OPENAPI, "07","JSON校验异常", "JSON校验异常"),
    EGNING_PARAM_EMPTY(CodeModuleEnum.OPENAPI, "08","输入参数为空", "输入参数为空"),
    EGNING_SYSTEM_ERROR(CodeModuleEnum.OPENAPI, "09","ENGINE系统异常", "ENGINE系统异常"),
    EGNING_ORDER_ERROR(CodeModuleEnum.OPENAPI, "10","查询PHP订单异常", "查询PHP订单异常"),

    MQ_Call_ERROR(CodeModuleEnum.OPENAPI, "07111", "MQ消费异常", "MQ消费异常");
    /**************************API对接相关码相关码 end***********************************/

    private static final String prefix = "5";
    /**
     * 错误码
     */
    private final String code;
    /**
     * 提示信息
     */
    private final String msg;
    /**
     * 原始文案
     */
    private final String text;
    /**
     * 提示信息
     */
    private final String desc;

    /**
     * 返回信息载体
     */
    private final CodeMsgVo codeMsgVo;

    /**
     * 构造函数针对一些特殊的码
     *
     * @param code 错误码
     * @param msg  提示信息
     * @param desc 描述
     */
    CodeEnum(String code, String msg, String desc) {
        this.code = code;
        this.msg = msg;
        this.text = msg;
        this.desc = desc;
        this.codeMsgVo = CodeMsgVo.create(this.code, this.msg);
    }

    /**
     * 构造函数
     *
     * @param tradeModuleEnum 模块枚举
     * @param subCode         二级码值
     * @param msg             文案
     * @param msg             描述
     */
    CodeEnum(CodeModuleEnum tradeModuleEnum, String subCode, String msg, String desc) {
        this.code = prefix + tradeModuleEnum.getCode() + subCode;
        this.msg = formate(this.code, msg);
        this.text = msg;
        this.desc = desc;
        this.codeMsgVo = CodeMsgVo.create(this.code, this.msg);
    }
    /**
     * 格式化文案
     *
     * @param code 码值
     * @param msg  文案
     * @return 格式化后的文案
     */
    private static String formate(String code, String msg) {
        return String.format(ICode.DEFAULT_FORMAT, msg, code);
    }

    /**
     * 打印所有的码
     */
    public static void print() {
        int i = 1;
        for (CodeEnum tradeCodeEnum : values()) {
//            System.out.println(String.format("%s.码值:%s 文案：%s 描述：%s", i++, tradeCodeEnum.getCode(), tradeCodeEnum.getMsg(), tradeCodeEnum.getDesc()));
            System.out.println(String.format("%s ordersubmit %s %s", tradeCodeEnum.getCode(), tradeCodeEnum.getMsg(), tradeCodeEnum.getDesc()));
        }
    }

    public static void main(String[] args) {
        CodeEnum.print();
    }

    @Override
    public boolean isExpect() {
        return ICode.CODE_OK.equals(this.getCode());
    }

    @Override
    public boolean isTransfer() {
        return ICode.CODE_TRANSFER.equals(this.getCode());
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    public String getText() {
        return text;
    }

    private String getDesc() {
        return this.desc;
    }

    public CodeMsgVo getCodeMsgVo() {
        return codeMsgVo;
    }

    public CodeMsgVo toTransfer(String msg) {
        return CodeMsgVo.create(ICode.CODE_TRANSFER, getTransfer(msg));
    }

    /**
     * 获取该枚举值得透传文案透传格式化
     *
     * @param msg 透传文案
     * @return String
     */
    public String getTransfer(String msg) {
        return formate("T" + this.getCode(), msg);
    }

    /**
     * 判断是否与枚举码相等
     *
     * @param code 需要比较的码
     * @return true：相等；false；不相等
     */
    public boolean equals(String code) {
        return this.getCode().equals(code);
    }
}
