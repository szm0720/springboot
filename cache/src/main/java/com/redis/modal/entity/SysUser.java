package com.redis.modal.entity;

/**
 * @author: shimingming
 * @create: 2018-10-10
 * @description:
 **/

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Table(name = "sys_user")
public class SysUser implements Serializable {

    @Id
    @Column(name = "id")
    private String id;
    /**
     * 登录名
     */
    @Column(name = "login_name")
    private String username;
    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

}
