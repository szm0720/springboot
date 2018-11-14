package com.redis.normal.modal.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 *
 */
@ApiModel
@Data
public class LogPageDTO implements Serializable {
    @ApiModelProperty(value = "页码",required = false)
    private int page;
    @ApiModelProperty(value = "条数",required = false)
    private int limit;
    @ApiModelProperty(value = "应用KEY",required = false)
    private Integer appKey;
    @ApiModelProperty(value = "状态，0成功；1失败",required = false)
    private int status;
    @ApiModelProperty(value = "调用类型，1调用日志；2回调日志",required = false)
    private int type;
    @ApiModelProperty(value = "开始时间",required = false)
    private Date startTime;
    @ApiModelProperty(value = "结束时间",required = false)
    private Date endTime;
}