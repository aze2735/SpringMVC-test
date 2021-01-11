package com.huadi.service;

import com.huadi.pojo.Account;

public interface AccountService {

    public Account validateUser(Account account);

    public boolean register(Account account);
}
