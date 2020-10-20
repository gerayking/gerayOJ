package com.gerayking.gerayoj.Controller;

import com.alibaba.fastjson.JSON;
import com.gerayking.gerayoj.mapper.UserMapper;
import com.gerayking.gerayoj.pojo.User;
import com.gerayking.gerayoj.pojo.UserExample;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/login")
    @ResponseBody
    public String login(String username,
                        String password,
                        HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        System.out.println(username);
        System.out.println(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);
        Map<String,Object> response = new HashMap<>();
        if(subject.isAuthenticated()){
            response.put("status",200);
            response.put("msg","登录成功");
            UserExample userExample = new UserExample();
            userExample.createCriteria()
                    .andUsernameEqualTo(username);
            List<User> users = userMapper.selectByExample(userExample);
            User user = users.get(0);
            request.getSession().setAttribute("user",user);
            return JSON.toJSONString(response);
        }else{
            response.put("status",201);
            response.put("msg","登录失败");
            return JSON.toJSONString(response);
        }
    }
    @ResponseBody
    @PostMapping("/register")
    public String register(
            @RequestParam("email") String email,
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andEmailEqualTo(email);
        List<User> users = userMapper.selectByExample(userExample);
        Map<String,Object> response = new HashMap<>();
        // 如果不为空
        if(users.isEmpty() == false){
            response.put("status",201);
            response.put("msg","该邮箱已被注册");
            return JSON.toJSONString(response);
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setNickname(username);
        userMapper.insert(user);
        response.put("status",200);
        response.put("msg","注册成功");
        return JSON.toJSONString(response);
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        request.getSession().setAttribute("user",null);
        return "index";
    }
}
