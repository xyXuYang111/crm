package com.xuyang.crm.repsitory;

import com.xuyang.crm.model.User;
import com.xuyang.crm.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 04:13
 * @Description:
 */
@Slf4j
@Data
@Component
public class UserRepositry {

    @Autowired
    private UserService userService;

    /**
     * key为它的条件
     * @param user
     * @param key
     * @return
     */
    @Cacheable(value = "cacheName", key = "'ecache_list_user_'+ #key")
    public List<User> userList(User user, String key) {
        log.info("获取用户");
        return userService.userList(user);
    }

    /**
     *
     * @param user
     * @param key
     * @return
     */
    @Cacheable(value = "cacheName", key = "'ecache_info_'+ #key")
    public List<User> userInfo(User user, String key) {
        log.info("获取用户");
        return userService.userInfo(user);
    }

    public void insertUser(User user) {
        log.info("新增用户");
        userService.insertUser(user);
    }

    @CachePut(value = "cacheName", key = "'ecache_user_'+ #key")
    public void updateUser(User user, String key) {
        log.info("修改用户");
        userService.updateUser(user);
    }
}
