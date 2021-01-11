package com.huadi.service.impl;

import com.huadi.dao.UserDao;
import com.huadi.dao.impl.UserDaoImpl;
import com.huadi.mapper.UserMapper;
import com.huadi.pojo.User;
import com.huadi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUser(int userId)  {
        return userMapper.getUser(userId);
    }

    public List<User> getUserList()  {
        return userMapper.getUserList();
    }

    public void addUser(User user) {
             userMapper.addUser(user);
    }

    public void updateUser(User user) {
          userMapper.updateUser(user);
    }

    public void deleteUser(int userId)  {
          userMapper.deleteUser(userId);
    }




}
