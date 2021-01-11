package com.huadi.dao;

import com.huadi.pojo.User;

import java.util.List;

public interface UserDao {

    public void deleteUser(int userId) throws ClassNotFoundException;

    public void addUser(User user) throws ClassNotFoundException;

    public void updateUser(User user) throws ClassNotFoundException;

    public User getUser(int userId) throws ClassNotFoundException;

    public List<User> getUserList() throws ClassNotFoundException;
}
