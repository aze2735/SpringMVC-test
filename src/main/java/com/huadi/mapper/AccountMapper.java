package com.huadi.mapper;

import com.huadi.pojo.Account;
import com.huadi.pojo.User;

public interface AccountMapper {

    public Account getLoginUser(Account account);
    public boolean registerUser(Account account);
}
