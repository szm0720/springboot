package com.redis.normal.service;

import com.redis.normal.common.*;
import com.redis.normal.enums.CallTypeEnum;
import com.redis.normal.enums.RepeatCallBackEnum;
import com.redis.normal.mapper.InterfaceFromLogMapper;
import com.redis.normal.mapper.InterfaceToToMapper;
import com.redis.normal.modal.dto.InterfaceFromLogDTO;
import com.redis.normal.modal.dto.InterfaceToLogDTO;
import com.redis.normal.modal.from.InterfaceFromLog;
import com.redis.normal.modal.from.InterfaceToLog;
import com.redis.normal.template.BaseInterfaceTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
@Slf4j
public class InterfaceLogService extends BaseInterfaceTemplate<InterfaceFromLogDTO, String> {
    @Resource
    InterfaceFromLogMapper interfaceFromLogMapper;
    @Resource
    InterfaceToToMapper interfaceToToMapper;
    @Override
    public Result<String> submit(InterfaceFromLogDTO data) throws Exception {
        Result<String> result = super.submit(data);
        return result;
    }

    @Override
    public ICode basicCheck(InterfaceFromLogDTO data) throws Exception {
        //基本信息的校验
        if (data.getThirdId() == null) {
            log.error("InterfaceFromLogDTO-thirdID参数校验失败:[{}]",data.getThirdId());
            return CodeEnum.FROMLOG_PARAM_ERROR.getCodeMsgVo();
        }
        return CodeEnum.OK.getCodeMsgVo();
    }

    @Override
    public Result businessCheck(InterfaceFromLogDTO data) throws Exception {
        return Result.success(null);
    }

    @Override
    public Result consume(InterfaceFromLogDTO data) throws Exception {
        InterfaceFromLog fromLog=new InterfaceFromLog();
        String result="SUCCESS";
        fromLog= ConverterFactory.createFromConverter().convert(data,fromLog);
        int insert = this.interfaceFromLogMapper.insert(fromLog);
        //重试3次
        int tryCount = 3;
        while (true) {
            if (insert<0) {
                tryCount--;
                if (tryCount < 0) {
                    break;
                }
                log.info("{}interfaceFromLogMapper:{}次,Status:{}" , data.getThirdId(),tryCount,insert);
                insert = this.interfaceFromLogMapper.insert(fromLog);
            }else{
                break;
            }
        }
        if (insert<0) {
            log.error("interfaceFromLogMapper-入库失败:[{}]",data);
            CodeMsgVo iCodeMsg = CodeEnum.FROMLOG_SQL_ERROR.getCodeMsgVo();
            return Result.create(iCodeMsg, "ERROR");
        }
        return Result.success(result);
    }

    @Override
    public void async(InterfaceFromLogDTO data) {

    }

    public Result saveToLog(InterfaceToLogDTO data) throws Exception {
        InterfaceToLog fromLog=new InterfaceToLog();
        String result="SUCCESS";
        fromLog= ConverterFactory.createToConverter().convert(data,fromLog);
        int insert = this.interfaceToToMapper.insert(fromLog);
        //重试3次
        int tryCount = 3;
        while (true) {
            if (insert<0) {
                tryCount--;
                if (tryCount < 0) {
                    break;
                }
                log.info("{}interfaceToToMapper-insert:调用失败，重试{}次,Status:{}" , data.getThirdId(),tryCount,insert);
                insert = this.interfaceToToMapper.insert(fromLog);
            }else{
                break;
            }
        }
        if (insert<0) {
            log.error("interfaceToToMapper-insert入库失败:[{}]",data);
            CodeMsgVo iCodeMsg = CodeEnum.TOLOG_SQL_ERROR.getCodeMsgVo();
            return Result.create(iCodeMsg, "ERROR");
        }
        return Result.success(result);
    }
    /**
     * 查询订阅列表
     */
    public List<InterfaceFromLogDTO> selectLogList(Map param, int type) throws Exception {
        List<InterfaceFromLogDTO> result=new ArrayList<InterfaceFromLogDTO>();
        switch(type){
            case 0:
                result=interfaceFromLogMapper.selectFromLogTotalList(param);
                break;
            case 1:
                result=interfaceFromLogMapper.selectFromLogList(param);
                break;
            case 2:
                result=interfaceToToMapper.selectToLogList(param);
                break;
            default:
              break;
        }
        if(result.isEmpty()){
            log.error("interfaceToToMapper-selectToLogList查询结果为空:[{}]",param);
        }
        return  result;
    }


    /**
     * 根据id 查询日志
     * @param id
     * @return
     */
    public InterfaceFromLog selectFromLog(Long id){
       InterfaceFromLog interfaceFromLog = interfaceFromLogMapper.selectByPrimaryKey(id);
       return interfaceFromLog;
    }

    /**
     * 根据id 查询日志
     * @param id
     * @return
     */
    public InterfaceToLog selectToLog(Long id){
        InterfaceToLog interfaceToLog = interfaceToToMapper.selectByPrimaryKey(id);
        return interfaceToLog;
    }
    /**
     * 保存回调日志
     */
    public Result saveCallBack(Integer id,Integer state,Integer type) throws Exception {
        Result result=new Result();
        if(type== CallTypeEnum.CALL_FROM.getCode()){
            result= saveCallBackFrom(id,state);
        }else {
            result= saveCallBackTo(id,state);
        }
        return  result;
    }
    /**
     * 保存回调日志
     */
    public Result saveCallBackFrom(Integer id,Integer state) throws Exception {
        InterfaceFromLog interfaceToLog = interfaceFromLogMapper.selectByPrimaryKey(id);
        int tryCount=interfaceToLog.getRetryCount()==null ? 0:interfaceToLog.getRetryCount();
        InterfaceFromLog fromLog =new InterfaceFromLog();
        fromLog.setId(id);
        if(state== RepeatCallBackEnum.SUCCESS.getCode()){
            fromLog.setState(RepeatCallBackEnum.SUCCESS.getCode());
            fromLog.setRetryCount(tryCount+1);
        }else {
            fromLog.setRetryCount(tryCount+1);
        }
        Example example = new Example(InterfaceFromLog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        int update = interfaceFromLogMapper.updateByExampleSelective(fromLog, example);
        return Result.success(update);
    }
    /**
     * 保存回调日志
     */
    public Result saveCallBackTo(Integer id,Integer state) throws Exception {
        InterfaceToLog interfaceToLog = interfaceToToMapper.selectByPrimaryKey(id);
        InterfaceToLog toLog =new InterfaceToLog();
        toLog.setId(id);
        if(state== RepeatCallBackEnum.SUCCESS.getCode()){
            toLog.setState(RepeatCallBackEnum.SUCCESS.getCode());
            toLog.setRetryCount(interfaceToLog.getRetryCount()+1);
        }else {
            toLog.setRetryCount(interfaceToLog.getRetryCount()+1);
        }
        Example example = new Example(InterfaceToLog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",id);
        int update = interfaceToToMapper.updateByExampleSelective(interfaceToLog, example);
        return Result.success(update);
    }


}
