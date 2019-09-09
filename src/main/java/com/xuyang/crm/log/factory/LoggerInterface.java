package com.xuyang.crm.log.factory;

/**
 * @Auther: cypc
 * @Date: 2019/9/9 08:21
 * @Description:
 */
public interface LoggerInterface {

    /**
     * 新增数据库日志
     */
    public void insertSqlLogger() throws Exception;

    /**
     * 新增mongoDB日志
     */
    public void insertMongoDBLogger() throws Exception;
}
