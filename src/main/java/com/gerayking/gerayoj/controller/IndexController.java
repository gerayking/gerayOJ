package com.gerayking.gerayoj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping({"/","/index"})
    public String index(Model model){
        return "index";
    }
    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }
}
