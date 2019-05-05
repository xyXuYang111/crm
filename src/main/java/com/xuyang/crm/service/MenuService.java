package com.xuyang.crm.service;

import com.xuyang.crm.model.Menu;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 04:01
 * @Description:
 */
@Component
public interface MenuService {

    public List<Menu> menuList(Menu menu);

    public List<Menu> menuInfo(Menu menu);

    public void insertMenu(Menu menu);

    public void updateMenu(Menu menu);
}
