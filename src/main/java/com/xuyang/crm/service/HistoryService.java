package com.xuyang.crm.service;

import com.xuyang.crm.model.History;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 03:56
 * @Description:
 */
@Component
public interface HistoryService {

    public List<History> historyList(History history);

    public List<History> historyInfo(History history);

    public void insertHistory(History history);
}

