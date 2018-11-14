package com.redis.normal.common.converter;


import com.redis.normal.modal.dto.InterfaceFromLogDTO;
import com.redis.normal.modal.from.InterfaceFromLog;
import org.springframework.beans.BeanUtils;

/**
 * From日志参数转换
 */
public class FormLogConverter implements Converter<InterfaceFromLogDTO, InterfaceFromLog> {

    @Override
    public InterfaceFromLog convert(InterfaceFromLogDTO source, InterfaceFromLog target) throws Exception {
        BeanUtils.copyProperties(source,target);
        return target;
    }
}
