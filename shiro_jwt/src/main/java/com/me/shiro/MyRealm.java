package com.me.shiro;

/**
 * @author: shimingming
 * @create: 2018-10-08 16:39
 * @description: myrelam
 **/

import com.me.constants.CommonConstants;
import com.me.jwt.JWTHelper;
import com.me.util.StringHelper;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyRealm extends AuthorizingRealm {

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 只有当需要检测用户权限的时候才会调用此方法，例如checkRole,checkPermission之类的
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        String token = principals.toString();

        Claims infoFromToken = JWTHelper.getInfoFromToken(token);

        String username = StringHelper.getObjectValue(infoFromToken.get(CommonConstants.JWT_KEY_USERNAME));

        //获取当前redis中所有的 权限缓存,并赋值到权限中
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addStringPermission("/www.baidu.com");

        return simpleAuthorizationInfo;
    }

    /**
     * 默认使用此方法进行用户名正确与否验证，错误抛出异常即可。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {

        String token = (String) auth.getCredentials();
        Claims infoFromToken = JWTHelper.getInfoFromToken(token);

        // 解密获得username，用于和数据库进行对比
        String username = StringHelper.getObjectValue(infoFromToken.get(CommonConstants.JWT_KEY_USERNAME));

        if (username.isEmpty()) {
            throw new AuthenticationException("userid is empty; token invalid");
        }


        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }
}

