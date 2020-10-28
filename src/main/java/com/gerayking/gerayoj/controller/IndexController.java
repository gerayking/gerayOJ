package com.gerayking.gerayoj.controller;

import com.gerayking.gerayoj.mapper.UserMapper;
import com.gerayking.gerayoj.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping({"/","/index"})
    public String index(Model model){
        return "index";
    }
    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }
}
