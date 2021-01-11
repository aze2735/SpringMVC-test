package com.huadi.dao.impl;

import com.huadi.dao.UserDao;
import com.huadi.pojo.User;
import com.huadi.util.DBCollection;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
//@Repository
public class UserDaoImpl implements UserDao {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /*

    删除用户
     */
   public void deleteUser(int userId) throws ClassNotFoundException {
       con = DBCollection.getConnection();
       try {
           ps = con.prepareStatement("delete from t_user where user_id = ?");
           ps.setInt(1,userId);
           ps.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
    finally {
           DBCollection.closeResource(con,ps,rs);
       }
   }
    /*
     新增用户
     */
    public void addUser(User user) throws ClassNotFoundException {
        con = DBCollection.getConnection();
        try {
            ps = con.prepareStatement("insert into t_user(user_name,user_age,user_sex) values (?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setInt(2,user.getAge());
            ps.setString(3,user.getSex());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
           DBCollection.closeResource(con,ps,rs);
        }
    }

    public void updateUser(User user) throws ClassNotFoundException {
        Connection con = DBCollection.getConnection();
        try {
            ps =  con.prepareStatement("update t_user set user_name = ?,user_sex =?,user_age =? where user_id =?");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getSex());
            ps.setInt(3,user.getAge());
            ps.setInt(4,user.getUserId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DBCollection.closeResource(con,ps,rs);
        }
    }

    /*
    获取一个用户
     */
    public User getUser(int userId) throws ClassNotFoundException {
        Connection con = DBCollection.getConnection();
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement("select * from t_user where user_id = ?");
            ps.setInt(1,userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user = new User();
                int id = rs.getInt("user_id");
                String name = rs.getString("user_name");
                int age = rs.getInt("user_age");
                String sex = rs.getString("user_sex");
                user.setUserId(id);
                user.setUsername(name);
                user.setAge(age);
                user.setSex(sex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    /*
    获取用户列表
     */
    public List<User> getUserList() throws ClassNotFoundException {
        Connection con = DBCollection.getConnection();
        List<User> list = new ArrayList<User>();
        User user = null;
        try {
            PreparedStatement ps = con.prepareStatement("select * from t_user");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                user = new User();
                int id = rs.getInt("user_id");
                String name = rs.getString("user_name");
                int age = rs.getInt("user_age");
                String sex = rs.getString("user_sex");
                user.setUserId(id);
                user.setUsername(name);
                user.setAge(age);
                user.setSex(sex);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }


}
