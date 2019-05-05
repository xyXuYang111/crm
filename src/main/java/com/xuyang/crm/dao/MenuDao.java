package com.xuyang.crm.dao;

import com.xuyang.crm.annotation.MyBatisDao;
import com.xuyang.crm.model.Menu;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 03:10
 * @Description:
 */
@MyBatisDao
public interface MenuDao {

    public List<Menu> menuList(Menu menu);

    public List<Menu> menuInfo(Menu menu);

    public void insertMenu(Menu menu);

    public void updateMenu(Menu menu);
}
