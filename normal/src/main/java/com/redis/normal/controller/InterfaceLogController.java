package com.redis.normal.controller;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.redis.normal.annotation.BusinessLog;
import com.redis.normal.common.*;
import com.redis.normal.enums.CodeEnum;
import com.redis.normal.modal.dto.InterfaceFromLogDTO;
import com.redis.normal.modal.dto.InterfaceToLogDTO;
import com.redis.normal.modal.dto.LogPageDTO;
import com.redis.normal.modal.from.InterfaceFromLog;
import com.redis.normal.modal.from.InterfaceToLog;
import com.redis.normal.modal.vo.CodeMsgVo;
import com.redis.normal.service.InterfaceLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * @author
 */
@Api(value = "InterfaceLogController",description = "接口日志管理")
@RequestMapping("/corelog")
@RestController
@Slf4j
public class InterfaceLogController {
    @Autowired
    InterfaceLogService interfaceLogService;


    @ApiOperation(value="保存调用saveFromLog", notes="保存调用saveFromLog")
    @ApiImplicitParam(name = "fromLog", value = "Fromlog实体fromLog", required = true, dataType = "InterfaceFromLogDTO")
    @BusinessLog(logInfo = "保存调用saveFromLog")
    @RequestMapping(value = "/savefromLog",method = RequestMethod.POST)
    public Result savefromLog(@RequestBody InterfaceFromLogDTO fromLog) {
        try {
            Result<String> logResult=interfaceLogService.submit(fromLog);
            return logResult;
        } catch (Exception e) {
            log.error(fromLog.getThirdId()+"interfaceLogService-submit异常:" + e.getMessage(), e);
            CodeMsgVo iCodeMsg = CodeEnum.FROMLOG_SYSTEM_ERROR.getCodeMsgVo();
            return Result.create(iCodeMsg.getCode(),iCodeMsg.getMsg(), "ERROR",e.getMessage());
        }
    }
    @ApiOperation(value="保存回调saveToLog", notes="保存回调saveToLog")
    @ApiImplicitParam(name = "toLog", value = "Tolog实体toLog", required = true, dataType = "InterfaceToLogDTO")
    @BusinessLog(logInfo = "保存回调saveToLog")
    @RequestMapping(value = "/saveToLog",method = RequestMethod.POST)
    public Result saveToLog(@RequestBody InterfaceToLogDTO toLog) {
        try {
            Result<String> logResult=interfaceLogService.saveToLog(toLog);
            return logResult;
        } catch (Exception e) {
            log.error(toLog.getThirdId()+"interfaceLogService-saveToLog异常:" + e.getMessage(), e);
            CodeMsgVo iCodeMsg = CodeEnum.TOLOG_SYSTEM_ERROR.getCodeMsgVo();
            return Result.create(iCodeMsg.getCode(),iCodeMsg.getMsg(), "ERROR",e.getMessage());
        }
    }

    @ApiOperation(value="分页查询调用日志列表", notes="分页查询调用日志列表")
    @ApiImplicitParam(name = "logPage", value = "LogPageDTO实体logPage", required = false, dataType = "LogPageDTO")
    @RequestMapping(value = "/selectLogPageList",method = RequestMethod.POST)
    public PageResult<List<InterfaceFromLogDTO>> selectLogPageList(@RequestBody LogPageDTO logPage) {
        PageHelper.startPage(logPage.getPage(), logPage.getLimit());
        List<InterfaceFromLogDTO> list = null;
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Map<String,Object> pageMap = Maps.newHashMap();
            pageMap.put("appKey",logPage.getAppKey());
            if(logPage.getStatus()!=8){
                pageMap.put("state",logPage.getStatus());
            }
            if(null !=logPage.getStartTime()){
                pageMap.put("startTime", DateBuilder.toDayBeginStr(logPage.getStartTime()) );
            }
            if(null !=logPage.getEndTime()){
                pageMap.put("endTime", DateBuilder.toDayEndStr(logPage.getEndTime()) );
            }
            list = interfaceLogService.selectLogList(pageMap,logPage.getType());
        } catch (Exception e) {
            log.error("interfaceLogService-selectLogList异常:" + e.getMessage(), e);
            CodeMsgVo iCodeMsg = CodeEnum.TOLOG_SYSTEM_ERROR.getCodeMsgVo();
            return PageResult.getPageFail(e.getMessage(),iCodeMsg.getCode(),iCodeMsg.getMsg());
        }
        PageResult pageResult= PageResult.getPageSuccess(list);
        return pageResult;
    }

    @ApiOperation(value="查询selectfromLog", notes="查询selectfromLog")
    @ApiImplicitParam(name = "selectfromLog", value = "selectfromLog实体fromLog", required = true, dataType = "InterfaceFromLogDTO")
    @BusinessLog(logInfo = "查询selectfromLog")
    @RequestMapping(value = "/selectFromLog/{id}",method = RequestMethod.GET)
    public Result selectFromLog(@PathVariable Long id)  {
        InterfaceFromLog interfaceFromLog = interfaceLogService.selectFromLog(id);
        Result success = Result.create("0", "success", interfaceFromLog);
        return success;
    }

    @ApiOperation(value="查询selectToLog", notes="查询selectToLog")
    @ApiImplicitParam(name = "selectToLog", value = "selectToLog实体toLog", required = true, dataType = "InterfaceToLogDTO")
    @BusinessLog(logInfo = "查询selectToLog")
    @RequestMapping(value = "/selectToLog/{id}",method = RequestMethod.GET)
    public Result selectToLog(@PathVariable Long id)  {
        InterfaceToLog interfaceToLog = interfaceLogService.selectToLog(id);
        Result success = Result.create("0", "success", interfaceToLog);
        return success;
    }
    @ApiOperation(value = "保存回调日志")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="日志id",required=true,dataType="Integer",paramType="path"),
            @ApiImplicitParam(name="state",value="状态",required=true,dataType="Integer",paramType="path"),
            @ApiImplicitParam(name="type",value="回调类型",required=true,dataType="Integer",paramType="path")})
    @RequestMapping(value = "/saveCallBack/{id}/{state}/{type}", method = RequestMethod.GET)
    public Result saveCallBack(@PathVariable("id") Integer id, @PathVariable("state") Integer state, @PathVariable("type") Integer type) {
        try {
            Result result=interfaceLogService.saveCallBack(id,state,type);
            return result;
        } catch (Exception e) {
            log.error(log.getName()+"interfaceLogService-saveCallBack异常:" + e.getMessage(), e);
            CodeMsgVo iCodeMsg = CodeEnum.LOG_CALLBACK_ERROR.getCodeMsgVo();
            return Result.create(iCodeMsg.getCode(),iCodeMsg.getMsg(),e.getMessage());
        }
    }

}
