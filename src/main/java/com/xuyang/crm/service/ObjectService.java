package com.xuyang.crm.service;

import com.xuyang.crm.model.ObjectValue;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/7/28 22:22
 * @Description:
 */
public interface ObjectService {

    public List<ObjectValue> objectValueList(ObjectValue objectValue) throws Exception;

    public List<ObjectValue> objectValueList(ObjectValue objectValue, String startIndex, String pageSize) throws Exception;

    public ObjectValue objectValueInfo(ObjectValue objectValue) throws Exception;

    public void insertObjectValue(ObjectValue objectValue) throws Exception;

    public void updateObjectValue(ObjectValue objectValue) throws Exception;

    public void deleteObjectValue(ObjectValue objectValue) throws Exception;
}
