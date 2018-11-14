package com.redis.normal.modal.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@Data
public class InterfaceToLogDTO implements Serializable {
    @ApiModelProperty(value = "用户id", required = false)
    private Integer id;
    @ApiModelProperty(value = "应用key",required = false)
    private Integer appKey;
    @ApiModelProperty(value = "调用类型 1调用；2回调",required=false)
    private Integer callType;
    @ApiModelProperty(value = "第三方ID", required = true)
    private String thirdId;
    @ApiModelProperty(value = "应用编码", required = true)
    private String appcode;
    @ApiModelProperty(value = "调用平台", required = true)
    private String platform;
    @ApiModelProperty(value = "接口名称", required = true)
    private String interfaceinfo;
    @ApiModelProperty(value = "请求报文", required = true)
    private String requestMessage;
    @ApiModelProperty(value = "响应报文", required = true)
    private String responseMessage;
    @ApiModelProperty(value = "状态，0成功；1失败", required = true)
    private Integer state;
    @ApiModelProperty(value = "重试次数", required = true)
    private Integer retryCount;
    @ApiModelProperty(value = "响应时间", required = true)
    private Date responseTime;
    @ApiModelProperty(value = "首次执行时间", required = true)
    private Date createTime;
    @ApiModelProperty(value = "最近更新时间", required = true)
    private Date updateTime;
    @ApiModelProperty(value = "请求时间", required = true)
    private Date requestTime;
    @ApiModelProperty(value = "接口URL", required = true)
    private String interfaceUrl;
}