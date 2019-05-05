package com.xuyang.crm.repsitory;

import com.xuyang.crm.dao.HistoryDao;
import com.xuyang.crm.model.History;
import com.xuyang.crm.service.HistoryService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
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
@Component
public class HistoryRepositry{

    @Autowired
    private HistoryService historyService;

    @Cacheable(value = "cacheName", key = "'ecache_list_history_'+ #key")
    public List<History> historyList(History history, String key) {
        log.info("获取历史记录");
        return historyService.historyList(history);
    }

    @Cacheable(value = "cacheName", key = "'ecache_info_history_'+ #key")
    public List<History> historyInfo(History history, String key) {
        log.info("获取历史记录");
        return historyService.historyInfo(history);
    }

    public void insertHistory(History history) {
        log.info("新增历史记录");
        historyService.insertHistory(history);
    }
}
