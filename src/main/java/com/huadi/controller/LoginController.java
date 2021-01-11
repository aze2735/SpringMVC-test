package com.huadi.controller;


import com.huadi.pojo.User;
import com.huadi.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller  //表明这个一个Controller
@RequestMapping(value = "/user")
public class LoginController {

  /*
    请求参数绑定
   */
    @RequestMapping(value = "/**/login/{userid}") //匹配页面发送的"/user/login"请求
    public String getLogin(@RequestParam("username") String username,
                           @RequestParam("password")String password){
        System.out.println("用户名:"+username);
        System.out.println("密码:"+password);
        return "success";
    }

   /*
     路径绑定参数
    */
    @RequestMapping(value = "/login/{username}/{password}")
    public String getLogin2(@PathVariable("username") String username,
                            @PathVariable("password")String password){

        System.out.println("username:"+username);
        System.out.println("password:"+password);
        return "success";
    }

    /*
      javabean绑定参数进行传递
     */
    @RequestMapping(value = "/login/user",method = RequestMethod.POST)
    public String getLogin3(User user){
        System.out.println(user.getUserId()+"/"+user.getUsername()+user.getAge());
        return "success";
    }

    /*
      采用HttpRequest,HttpResponse对象来进行参数传递
     */
    @RequestMapping(value = "/login/testServlet")
    public String getLogin4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        request.getRequestDispatcher("/WEB-INF/jsps/success.jsp").forward(request,response);

        return "";
    }

  /*
    Model数据绑定
   */
  @RequestMapping(value = "/login/getUserByModel",method = RequestMethod.POST)
    public String getUserByModel(Model model) throws ClassNotFoundException {
       UserServiceImpl userServiceImpl =  new UserServiceImpl();
//       User user = userServiceImpl.getUser();
//       model.addAttribute("User",user);
      List<User> userList = userServiceImpl.getUserList();
      model.addAttribute("userList",userList);
       return "success";
  }

  /*
   ModelMap数据绑定
   */
  @RequestMapping(value = "/login/getUserByMap",method = RequestMethod.POST)
    public String getUserByMap(ModelMap map,int userId) throws ClassNotFoundException {
        UserServiceImpl userServiceImpl = new UserServiceImpl();
        User user = userServiceImpl.getUser(userId);
        System.out.println(user);
        map.put("User",user);
        return "showUser";
  }

  /*
    ModelAndView数据绑定
   */
  @RequestMapping(value = "/login/getUserByModelAndView",method = RequestMethod.POST)
    public ModelAndView getUserByModelAndView(ModelAndView modelAndView) throws ClassNotFoundException {
      UserServiceImpl userServiceImpl = new UserServiceImpl();
      List<User> userList = userServiceImpl.getUserList();

      modelAndView.setViewName("success");
      modelAndView.addObject("userList",userList);
      return  modelAndView;

  }

  /*
    Json对象解析并且传递到视图
   */
     @ResponseBody //使方法返回json字符串
     @RequestMapping(value =  "/login/getUserByJson",method = RequestMethod.POST)
     public User getUserByJson(int userId) throws ClassNotFoundException {
            UserServiceImpl userServiceImpl = new UserServiceImpl();
            User user = userServiceImpl.getUser(userId);
            return user;
      }


  }

