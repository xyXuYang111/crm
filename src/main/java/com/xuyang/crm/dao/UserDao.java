package com.xuyang.crm.dao;

import com.xuyang.crm.annotation.MyBatisDao;
import com.xuyang.crm.model.User;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 03:15
 * @Description:
 */
@MyBatisDao
public interface UserDao {

    public List<User> userList(User user);

    public User userInfo(User user);

    public void insertUser(User user);

    public void updateUser(User user);
}
