package com.huadi.controller;

import com.huadi.pojo.User;
import com.huadi.service.UserService;
import com.huadi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/manage")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList")
    public String getUserByModel(Model model) throws ClassNotFoundException {

        List<User> userList = userService.getUserList();
        System.out.println("========"+userList.size()+"=========");
        model.addAttribute("userList",userList);
        return "success";
    }

    /*
      修改用户页面
     */
    @RequestMapping(value = "/update/{userId}",method = RequestMethod.GET)
    public String updateUser(@PathVariable("userId") int userId,Model model) throws ClassNotFoundException {
           User user = userService.getUser(userId);
           model.addAttribute("User",user);
           return "update";
    }

    /*
      修改用户
     */
    @RequestMapping(value = "/doUpdate",method = RequestMethod.POST)
    public String doUpdate(User user) throws ClassNotFoundException {
        System.out.println("------------doUpdate--------------");
        userService.updateUser(user);
        return "redirect:/manage/getUserList";  //重定向
    }

    /*
    删除用户
     */
    @RequestMapping(value = "/delete/{userId}",method = RequestMethod.GET)
    public String doDelete(@PathVariable("userId") int userId) throws ClassNotFoundException {
        userService.deleteUser(userId);
        return "redirect:/manage/getUserList";//重定向
    }

    /*
    新增页面
     */
    @RequestMapping(value = "/addPage")
    public String addUser(){
        return "addUser";
    }

    /*
    新增提交
     */
    @RequestMapping(value = "/doAdd",method = RequestMethod.POST)
    public String doAddUser(User user) throws ClassNotFoundException {
        userService.addUser(user);
        return "redirect:/manage/getUserList";//重定向
    }
}
