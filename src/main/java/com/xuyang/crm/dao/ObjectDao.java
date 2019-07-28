package com.xuyang.crm.dao;

import com.xuyang.crm.annotation.MyBatisDao;
import com.xuyang.crm.model.ObjectValue;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/7/28 12:05
 * @Description:
 */
@MyBatisDao
public interface ObjectDao {

    public List<ObjectValue> objectValueList(ObjectValue objectValue) throws Exception;

    public ObjectValue objectValueInfo(ObjectValue objectValue) throws Exception;

    public void insertObjectValue(ObjectValue objectValue) throws Exception;

    public void updateObjectValue(ObjectValue objectValue) throws Exception;

    public void deleteObjectValue(ObjectValue objectValue) throws Exception;
}
