package com.huadi.dao.impl;


import com.huadi.dao.AccountDao;
import com.huadi.pojo.Account;
import com.huadi.util.DBCollection;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 登录及注册的数据访问层
 */
@Component
//@Repository
public class AccountDaoImpl implements AccountDao {

    private static Connection connection =  null;
    private static PreparedStatement ps = null;
    private static ResultSet rs = null;
    /*
    登录验证
     */
    public  boolean validateUser(Account account){
        try {
            connection = DBCollection.getConnection();
            try {
                ps = connection.prepareStatement("select * from t_account where username = ? and password = ?");
                ps.setString(1,account.getUsername());
                ps.setString(2,account.getPassword());
                rs = ps.executeQuery();
                if(rs.next()){
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    /*
    登录注册
     */
    public boolean register(Account account){
        try {
            connection = DBCollection.getConnection();
            try {
                ps = connection.prepareStatement("insert into t_account (username,password) value (?,?)");
                ps.setString(1,account.getUsername());
                ps.setString(2,account.getPassword());
                int number = ps.executeUpdate();
                if(number >0){
                    return true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
