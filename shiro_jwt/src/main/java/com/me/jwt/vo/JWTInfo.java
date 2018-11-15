package com.me.jwt.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:
 * @Date: 2018/4/28 16:19
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JWTInfo implements IJWTInfo {
    private String openId;
    private String username;//云鸟业务人员姓名，对应下面id
    private String id;//云鸟业务人员的id,user 工程 sys_user表中的id
    private Long phone;//普通游客的手机号
    private String type;//type 表示当前token 的类型：APP，Applets，BSS


}
