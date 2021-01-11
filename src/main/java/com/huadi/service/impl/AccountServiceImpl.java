package com.huadi.service.impl;

import com.huadi.dao.AccountDao;
import com.huadi.dao.impl.AccountDaoImpl;
import com.huadi.mapper.AccountMapper;
import com.huadi.mapper.UserMapper;
import com.huadi.pojo.Account;
import com.huadi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    public Account validateUser(Account account) {
        return accountMapper.getLoginUser(account);
    }

    public boolean register(Account account) {
        accountMapper.registerUser(account);
        return true;
    }
}
