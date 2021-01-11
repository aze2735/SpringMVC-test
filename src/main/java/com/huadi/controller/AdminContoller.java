package com.huadi.controller;


import com.huadi.pojo.Account;
import com.huadi.pojo.User;
import com.huadi.service.AccountService;
import com.huadi.service.UserService;
import com.huadi.service.impl.AccountServiceImpl;
import com.huadi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AdminContoller {


      @Autowired
      private AccountService accountService;

      @Autowired
      private UserService userService;

    /*
    登录验证
     */
    @RequestMapping(value = "/validate",method = RequestMethod.GET)
    public String validateUser(@RequestParam("username")String username,
                               @RequestParam("password")String password,
                               Model model) throws ClassNotFoundException {
        System.out.println(username +"/"+password);
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
         Account account1 = accountService.validateUser(account);
         if(account1!= null){
            List<User> userList = userService.getUserList();
             System.out.println("++==="+userList.size()+"====");
            model.addAttribute("userList",userList);
            return "success";
         }
         else{
             return "login";
         }
    }

    /*
    注册用户
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String register(Account account,Model model){
      boolean result = accountService.register(account);
      if(result){
          model.addAttribute("result","注册成功");
          return "login";
      }
      else{
          model.addAttribute("result","注册失败");
          return "login";
      }
    }

    /*
    注册页面
     */
    @RequestMapping(value = "/registerPage")
    public String registerPage(){
        return "register";
    }
}
