package com.xuyang.crm.repsitory;

import com.xuyang.crm.model.History;
import com.xuyang.crm.service.HistoryService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

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

    @Cacheable(value = "ecacheName", key = "'ecache_list_history_'+ #key")
    public List<History> historyList(History history, String key) {
        log.info("获取历史记录");
        return historyService.historyList(history);
    }

    @Cacheable(value = "ecacheName", key = "'ecache_info_history_'+ #key")
    public List<History> historyInfo(History history, String key) {
        log.info("获取历史记录");
        return historyService.historyInfo(history);
    }

    /**
     * 干掉list缓存
     * @param history
     */
    @CacheEvict(value = "ecacheName", key = "ecache_list_history")
    public void insertHistory(History history) {
        log.info("新增历史记录");
        historyService.insertHistory(history);
    }

    /**
     * 干掉list缓存
     * @param history
     */
    @CacheEvict(value = "ecacheName", key = "'ecache_info_history_'+ #key")
    public void updateHistory(History history, String key) {
        log.info("新增历史记录");
        historyService.insertHistory(history);
    }
}
