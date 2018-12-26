package com.me.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.me.constants.CommonConstants;
import com.me.jwt.JWTHelper;
import com.me.jwt.vo.JWTInfo;
import com.me.util.StringHelper;
import io.jsonwebtoken.Claims;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author: shimingming
 * @create: 2018-12-25
 * @description:
 **/
@RestController
public class testController {

    @RequestMapping("/createToken")
    public String test (){
        String jwtExpire=String.valueOf(60*2);

        JWTInfo jwtInfo = new JWTInfo();
        jwtInfo.setProfile("d1");
        jwtInfo.setPhone(15103431293l);
        jwtInfo.setType("1");
        jwtInfo.setCustNo("001");
        jwtInfo.setOpenId("QASWED");
        String jwtToken = JWTHelper.generateToken(jwtInfo,  Integer.parseInt(jwtExpire));
        return jwtToken;
    }

    @RequestMapping("/verifyToken")
    public String verifyToken (@RequestParam("token") String token){
        Claims infoFromToken = JWTHelper.getInfoFromToken(token);

        String JWT_KEY_PROFILE = StringHelper.getObjectValue(infoFromToken.get(CommonConstants.JWT_KEY_PROFILE));
        String openId = infoFromToken.get(CommonConstants.JWT_KEY_OPENID)== null ? "0" : String.valueOf(infoFromToken.get(CommonConstants.JWT_KEY_OPENID));
        String userId = infoFromToken.get(CommonConstants.JWT_KEY_USER_ID)== null ? "0" : String.valueOf(infoFromToken.get(CommonConstants.JWT_KEY_USER_ID));
        String JWT_KEY_USERNAME = StringHelper.getObjectValue(infoFromToken.get(CommonConstants.JWT_KEY_USERNAME));
        String JWT_KEY_PHONE = StringHelper.getObjectValue(infoFromToken.get(CommonConstants.JWT_KEY_PHONE));
        String type = StringHelper.getObjectValue(infoFromToken.get(CommonConstants.JWT_KEY_TYPE));
        String custno = infoFromToken.get(CommonConstants.JWT_KEY_CUSTNO)== null ? "0" : String.valueOf(infoFromToken.get(CommonConstants.JWT_KEY_CUSTNO));

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("profile",JWT_KEY_PROFILE);
        jsonObject.put("openId",openId);
        jsonObject.put("userId",userId);
        jsonObject.put("username",JWT_KEY_USERNAME);
        jsonObject.put("phone",JWT_KEY_PHONE);
        jsonObject.put("type",type);
        jsonObject.put("custno",custno);

        return jsonObject.toJSONString();
    }
}
