package com.redis.service;

import com.redis.dao.CacheDao;
import com.redis.modal.entity.SysUser;
import com.redis.modal.form.JwtBssForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author: shimingming
 * @create: 2018-10-10
 * @description:
 **/
@Service
@Slf4j
public class CacheService {

    @Autowired
    CacheDao cacheDao;

    /**
     * 用户名，密码的校验
     * @param jwtBssForm
     */
    public String userPwdVerification(JwtBssForm jwtBssForm) {

        String username = jwtBssForm.getUsername();
        String plainPassword = jwtBssForm.getPassword();

        SysUser user = new SysUser();
        user.setUsername(username);
        List<SysUser> select =cacheDao.select(user);

        log.info("查询结果，条数：{}",select.size());
        Assert.isTrue(select.size()>0,"用户名输入错误");

        String id = select.get(0).getId();

        return id;

    }

}
