package com.me.controller;

import com.redis.modal.form.JwtBssForm;
import com.redis.service.CacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author: shimingming
 * @create: 2018-09-29 15:51
 * @description:
 **/
@RestController
@RequestMapping(value = "/cache")
@Slf4j
public class CacheController {

    @Resource
    CacheService cacheService;

    @RequestMapping(value = "/getId", method = RequestMethod.POST)
    @ResponseBody
    public  String getId(@Valid @ModelAttribute JwtBssForm jwtBssForm) {
        String tmpDir = System.getProperty("java.io.tmpdir");
        String id = cacheService.userPwdVerification(jwtBssForm);
        return  id;
    }


}
