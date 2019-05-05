package com.xuyang.crm.controller;

import com.xuyang.crm.model.Menu;
import com.xuyang.crm.repsitory.MenuRepostiry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 12:34
 * @Description:
 */
@Slf4j
@Controller
public class MenuController {

    @Autowired
    private MenuRepostiry menuRepostiry;

    @RequestMapping(value = "getMenuList", method = RequestMethod.GET)
    public String getMenuList(Menu menu, Model model, HttpSession session){

        String userID = (String) session.getAttribute("userID");
        log.info("获取目录清单");
        if(menu == null){
            //查询最大的目录
            Menu menuInfo = new Menu();
            menuInfo.setParentID("0");
            menuInfo.setUserID(userID);
            List<Menu> menuList = menuRepostiry.menuList(menuInfo, "0");
            model.addAttribute("menuList", menuList);
        }else {
            String menuID = menu.getMenuID();
            //查询最大的目录
            Menu menuInfo = new Menu();
            menuInfo.setMenuID(menuID);
            menuInfo.setUserID(userID);
            List<Menu> menuList = menuRepostiry.menuList(menuInfo, menuID);
            model.addAttribute("menuList", menuList);
        }
        return "index";
    }

    @RequestMapping(value = "getInsertMenu", method = RequestMethod.POST)
    public String getInsertMenu(){
        return "add";
    }

    @RequestMapping(value = "insertMenu", method = RequestMethod.POST)
    public String insertMenu(Menu menu, HttpSession session){
        log.info("新增目录清单");
        String userID = (String) session.getAttribute("userID");
        menu.setUserID(userID);
        menuRepostiry.insertMenu(menu);
        return "add";
    }
}