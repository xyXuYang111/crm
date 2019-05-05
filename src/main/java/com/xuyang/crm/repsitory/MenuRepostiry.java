package com.xuyang.crm.repsitory;

import com.xuyang.crm.dao.MenuDao;
import com.xuyang.crm.model.Menu;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 04:01
 * @Description:
 */
@Data
@Slf4j
@Component
public class MenuRepostiry{

    @Autowired
    private MenuDao menuDao;

    @Cacheable(value = "cacheName", key = "'ecache_list_menu_'+ #key")
    public List<Menu> menuList(Menu menu, String key) {
        log.info("获取菜单");
        return menuDao.menuList(menu);
    }

    @Cacheable(value = "cacheName", key = "'ecache_info_menu_'+ #key")
    public List<Menu> menuInfo(Menu menu, String key) {
        log.info("获取菜单");
        return menuDao.menuInfo(menu);
    }

    public void insertMenu(Menu menu) {
        log.info("新增菜单");
        menuDao.insertMenu(menu);
    }

    @CachePut(value = "cacheName", key = "'ecache_menu_'+ #key")
    public void updateMenu(Menu menu, String key) {
        log.info("修改菜单");
        menuDao.updateMenu(menu);
    }
}
