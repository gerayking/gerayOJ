package com.gerayking.gerayoj.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gerayking.gerayoj.mapper.UserInfoMapper;
import com.gerayking.gerayoj.pojo.UserInfo;
import com.gerayking.gerayoj.service.RegexService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {
    @Autowired
    UserInfoMapper userInfoMapper;
    @Autowired
    RegexService regexService;
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
            QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("username",username);
            UserInfo user = userInfoMapper.selectOne(queryWrapper);
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
        Map<String,Object> response = new HashMap<>();
        if(regexService.EmailCheck(email) == false){
            response.put("status",201);
            response.put("msg","邮箱错误");
            return JSON.toJSONString(response);
        }
        UserInfo user = new UserInfo();
        user.setUsername(username);
        user.setEmail(email);
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email",email);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        // 如果不为空
        if(userInfo != null){
            response.put("status",201);
            response.put("msg","该邮箱已被注册");
            return JSON.toJSONString(response);
        }
        user.setPassword(password);
        userInfoMapper.insert(user);
        response.put("status",200);
        response.put("msg","注册成功");
        return JSON.toJSONString(response);
    }
    @RequestMapping("/Logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated())SecurityUtils.getSubject().logout();
        return "index";
    }
}
