package com.redis.normal.common.converter;

import com.redis.normal.modal.dto.InterfaceToLogDTO;
import com.redis.normal.modal.from.InterfaceToLog;
import org.springframework.beans.BeanUtils;

/**
 * TO日志参数转换
 */
public class ToLogConverter implements Converter<InterfaceToLogDTO, InterfaceToLog> {

    @Override
    public InterfaceToLog convert(InterfaceToLogDTO source, InterfaceToLog target) throws Exception {
        BeanUtils.copyProperties(source,target);
        return target;
    }
}
