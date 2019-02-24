package com.crm.service;

import com.crm.pojo.BaseDict;

import java.util.List;

/**
 * 查询客户类型
 */

public interface BaseDictService {

    List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
}
