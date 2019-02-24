package com.crm.service;

import com.crm.mapper.BaseDictMapper;
import com.crm.pojo.BaseDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 查询客户类型，
 */

@Service
public class BaseDictServiceimpl implements BaseDictService {
    @Autowired
    private BaseDictMapper baseDictMapper;

    @Override
    public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
        return baseDictMapper.queryBaseDictByDictTypeCode(dictTypeCode);
    }
}
