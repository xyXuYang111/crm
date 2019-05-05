package com.xuyang.crm.service;

import com.xuyang.crm.model.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: xuy
 * @Date: 2019/5/4 04:09
 * @Description:
 */
@Component
public interface UserService {

    public List<User> userList(User user);

    public List<User> userInfo(User user);

    public void insertUser(User user);

    public void updateUser(User user);
}
