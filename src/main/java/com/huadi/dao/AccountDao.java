package com.huadi.dao;

import com.huadi.pojo.Account;

public interface AccountDao {

    public  boolean validateUser(Account account);

    public boolean register(Account account);


}
