package com.me.controller;

import com.me.jwt.JWTHelper;
import com.me.jwt.vo.JWTInfo;
import com.me.modal.form.JwtBssForm;
import com.me.modal.vo.VerificationTokenVo;
import com.me.util.Result;
import com.me.util.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author: shimingming
 * @create: 2018-09-29 15:51
 * @description: bss 项目认证
 **/
@RestController
@RequestMapping(value = "/bss")
@Slf4j
@Api(value = "BssController", description = "bss用户认证管理")
public class BssController {

    @Value("${jwt.expire:3600}")
    String jwtExpire;


    @ApiOperation(value = "bss登录（获取Token）")
    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    public Result<String> getToken(@Valid @ModelAttribute JwtBssForm jwtBssForm) {

        String token = generateToken("1", jwtBssForm);
        return ResultUtils.getSuccess(token);
    }

    /**
     * 生成token
     *
     * @param jwtBssForm
     * @return
     */
    public String generateToken(String id, JwtBssForm jwtBssForm) {

        JWTInfo jwtInfo = new JWTInfo();
        jwtInfo.setUsername(jwtBssForm.getUsername());
        jwtInfo.setId(id);
        jwtInfo.setType("1");
        String jwtToken = JWTHelper.generateToken(jwtInfo, Integer.parseInt(jwtExpire));
        return jwtToken;
    }

    @ApiOperation(value = "header 中带上token，验证通过，可以访问")
    @RequestMapping(value = "/jwt/verification", method = RequestMethod.POST)
    public String verification() {
        return "123";
    }

    @ApiOperation(value = "不需要验证的方法")
    @RequestMapping(value = "/verification2", method = RequestMethod.POST)
    public String verification2() {
        return "456";
    }


    @ApiOperation(value = "header 中带上token，验证请求uri")
    @RequestMapping(value = "/jwt/verificationToken", method = RequestMethod.POST)
    public Result<VerificationTokenVo> verificationToken(@RequestParam("uri") String uri) {

        String firstChar = uri.substring(0, 1);
        if (!"/".equals(firstChar)) {
            uri = "/" + uri;
        }

        String lastChar = uri.substring(uri.length() - 1, uri.length());
        if ("/".equals(lastChar)) {
            uri = uri.substring(0, uri.length() - 1);
        }

        //创建Subject
        Subject subject = SecurityUtils.getSubject();
        boolean updatePwd = false;
        if (subject.isAuthenticated()) {
            log.info("认证状态");
            updatePwd = subject.isPermitted(uri);
        }
        log.info("updatePwd:{}, uri:{}", updatePwd, uri);
        VerificationTokenVo verificationTokenVo = new VerificationTokenVo();
        verificationTokenVo.setFlag(updatePwd);
        log.info("verificationTokenVo_toStr,{}", verificationTokenVo.toString());
        return ResultUtils.getSuccess(verificationTokenVo);

    }


}
