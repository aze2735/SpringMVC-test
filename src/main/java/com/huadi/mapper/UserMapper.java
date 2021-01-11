package com.huadi.mapper;

import com.huadi.pojo.User;

import java.util.List;

public interface UserMapper {

    public void deleteUser(int userId) ;

    public void addUser(User user) ;

    public void updateUser(User user);

    public User getUser(int userId) ;

    public List<User> getUserList() ;
}
