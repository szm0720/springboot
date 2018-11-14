package com.redis.normal.mapper;


import com.redis.normal.config.CoreMapper;
import com.redis.normal.modal.dto.InterfaceFromLogDTO;
import com.redis.normal.modal.from.InterfaceToLog;

import java.util.List;
import java.util.Map;

public interface InterfaceToToMapper extends CoreMapper<InterfaceToLog> {
    List<InterfaceFromLogDTO> selectToLogList(Map<String, Object> param);
}
