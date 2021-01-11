package com.huadi.service;

import com.huadi.pojo.User;

import java.util.List;

public interface UserService {

    public User getUser(int userId);

    List<User> getUserList() ;

    public void addUser(User user);

    public void updateUser(User user) ;

    public void deleteUser(int userId) ;
}
