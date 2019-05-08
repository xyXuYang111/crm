package com.xuyang.crm.service.impl;

import com.xuyang.crm.dao.UserDao;
import com.xuyang.crm.model.User;
import com.xuyang.crm.service.UserService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 04:10
 * @Description:
 */
@Data
@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> userList(User user) {
        log.info("获取用户");
        return userDao.userList(user);
    }

    @Override
    public User userInfo(User user) {
        log.info("获取用户");
        return userDao.userInfo(user);
    }

    @Override
    public void insertUser(User user) {
        log.info("新增用户");
        userDao.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        log.info("修改用户");
        userDao.updateUser(user);
    }
}
