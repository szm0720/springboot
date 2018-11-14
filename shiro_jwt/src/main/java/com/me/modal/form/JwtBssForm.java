package com.me.modal.form;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: shimingming
 * @create: 2018-10-08 11:13
 * @description: bss 提交form
 **/
@Data
public class JwtBssForm {
    @ApiModelProperty(value="用户名",required = true)
    @NotNull
    private String username;
    @ApiModelProperty(value="密码",required = true)
    @NotNull
    private String password;
}