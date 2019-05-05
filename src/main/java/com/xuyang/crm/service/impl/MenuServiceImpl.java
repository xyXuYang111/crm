package com.xuyang.crm.service.impl;

import com.xuyang.crm.dao.MenuDao;
import com.xuyang.crm.model.Menu;
import com.xuyang.crm.service.MenuService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 04:01
 * @Description:
 */
@Data
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> menuList(Menu menu) {
        log.info("获取菜单");
        return menuDao.menuList(menu);
    }

    @Override
    public List<Menu> menuInfo(Menu menu) {
        log.info("获取菜单");
        return menuDao.menuInfo(menu);
    }

    @Override
    public void insertMenu(Menu menu) {
        log.info("新增菜单");
        menuDao.insertMenu(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        log.info("修改菜单");
        menuDao.updateMenu(menu);
    }
}
