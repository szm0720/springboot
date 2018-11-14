package com.redis.normal.modal.from;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Table(name = "interface_to_log")
public class InterfaceToLog implements Serializable {

    @Id
    @Column(name = "id")
    private Integer id;
    /**
     * 应用key
     */
    @Column(name = "app_key")
    private Integer appKey;

    /**
     * 第三方ID
     */
    @Column(name = "third_id")
    private String thirdId;

    /**
     * 应用编码
     */
    @Column(name = "app_code")
    private String appcode;


    /**
     * 记录调用平台(php_tms_openapi,php_platform_engine,默认是sparrow_service)
     */
    @Column(name = "platform")
    private String platform;

    /**
     * 接口名称
     */
    @Column(name = "interface_info")
    private String interfaceinfo;

    /**
     * 请求报文
     */
    @Column(name = "request_message")
    private String requestMessage;

    /**
     * 响应报文
     */
    @Column(name = "response_message")
    private String responseMessage;

    /**
     * 状态，0成功；1失败
     */
    @Column(name = "state")
    private Integer state;

    /**
     * 重试次数
     */
    @Column(name = "retry_count")
    private Integer retryCount;

    /**
     * 响应时间
     */
    @Column(name = "response_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date responseTime;

    /**
     * 首次执行时间
     */
    @Column(name = "create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;

    /**
     * 请求时间
     */
    @Column(name = "request_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date requestTime;

    /**
     * 接口URL
     */
    @Column(name = "interface_url")
    private String interfaceUrl;





}
