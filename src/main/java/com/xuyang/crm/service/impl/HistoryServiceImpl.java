package com.xuyang.crm.service.impl;

import com.xuyang.crm.dao.HistoryDao;
import com.xuyang.crm.model.History;
import com.xuyang.crm.service.HistoryService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 03:58
 * @Description:
 */
@Data
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Override
    public List<History> historyList(History history) {
        log.info("获取历史记录");
        return historyDao.historyList(history);
    }

    @Override
    public List<History> historyInfo(History history) {
        log.info("获取历史记录");
        return historyDao.historyInfo(history);
    }

    @Override
    public void insertHistory(History history) {
        log.info("新增历史记录");
        historyDao.insertHistory(history);
    }
}
