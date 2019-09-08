package com.xuyang.crm.log.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xuyang.crm.log.dao.LoggerDao;
import com.xuyang.crm.log.service.LoggerService;
import com.xuyang.crm.model.Logger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 许洋
 * @Date: 2019/9/7 23:37
 * @Description:
 */
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class LoggerServiceImpl implements LoggerService {

    @Autowired
    private LoggerDao loggerDao;

    @Override
    public Logger loggerInfo(Logger logger) throws Exception {
        return loggerDao.loggerInfo(logger);
    }

    @Override
    public List<Logger> loggerList(Logger logger) throws Exception {
        return loggerDao.loggerList(logger);
    }

    @Override
    public List<Logger> loggerList(Logger logger, int startIndex, int pageSize) throws Exception {
        PageHelper.startPage(startIndex, pageSize);
        PageInfo<Logger> loggerPageInfo = new PageInfo<>(loggerDao.loggerList(logger));
        return loggerPageInfo.getList();
    }

    @Override
    public void insertLogger(Logger logger) throws Exception {
        loggerDao.insertLogger(logger);
    }

    @Override
    public void updateLogger(Logger logger) throws Exception {
        loggerDao.updateLogger(logger);
    }

    @Override
    public void deleteLogger(Logger logger) throws Exception {
        loggerDao.deleteLogger(logger);
    }
}
