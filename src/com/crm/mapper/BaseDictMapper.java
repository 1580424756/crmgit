package com.crm.mapper;

import com.crm.pojo.BaseDict;

import java.util.List;

public interface BaseDictMapper {
    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
