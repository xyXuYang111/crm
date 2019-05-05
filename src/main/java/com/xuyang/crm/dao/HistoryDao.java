package com.xuyang.crm.dao;

import com.xuyang.crm.annotation.MyBatisDao;
import com.xuyang.crm.model.History;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 03:16
 * @Description:
 */
@MyBatisDao
public interface HistoryDao {

    public List<History> historyList(History history);

    public List<History> historyInfo(History history);

    public void insertHistory(History history);

    public void updateHistory(History history);
}
