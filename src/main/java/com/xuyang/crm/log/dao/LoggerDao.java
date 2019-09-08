package com.xuyang.crm.log.dao;

import com.xuyang.crm.annotation.MyBatisDao;
import com.xuyang.crm.model.Logger;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 23:33
 * @Description:
 */
@MyBatisDao
public interface LoggerDao {

    /**
     * 查询单个文件信息
     * @param logger
     * @return
     * @throws Exception
     */
    public Logger loggerInfo(Logger logger) throws Exception;

    /**
     * 查询多个文件信息
     * @param logger
     * @return
     * @throws Exception
     */
    public List<Logger> loggerList(Logger logger) throws Exception;

    /**
     * 新增文件信息
     * @param logger
     * @return
     * @throws Exception
     */
    public void insertLogger(Logger logger) throws Exception;

    /**
     * 新增文件信息
     * @param logger
     * @return
     * @throws Exception
     */
    public void updateLogger(Logger logger) throws Exception;

    /**
     * 新增文件信息
     * @param logger
     * @return
     * @throws Exception
     */
    public void deleteLogger(Logger logger) throws Exception;
}
