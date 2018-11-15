package com.redis.normal.mapper;


import com.redis.normal.config.CoreMapper;
import com.redis.normal.modal.dto.InterfaceFromLogDTO;
import com.redis.normal.modal.from.InterfaceFromLog;
//import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
//@Mapper
public interface InterfaceFromLogMapper extends CoreMapper<InterfaceFromLog> {

    List<InterfaceFromLogDTO> selectFromLogTotalList(Map<String, Object> param);

    List<InterfaceFromLogDTO> selectFromLogList(Map<String, Object> param);
}
