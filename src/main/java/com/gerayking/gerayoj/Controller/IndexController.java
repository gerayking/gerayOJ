package com.gerayking.gerayoj.Controller;

import com.gerayking.gerayoj.mapper.UserMapper;
import com.gerayking.gerayoj.pojo.Problem;
import com.gerayking.gerayoj.pojo.User;
import com.gerayking.gerayoj.pojo.UserExample;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.cs.US_ASCII;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/test")
    public String index(Model model, HttpRequest request){
        return "index";
    }
    @RequestMapping("/problemlist")
    public String goindex(Model model){
        List<Problem> problems = new ArrayList<>();
        problems.add(new Problem(2,"A - B Problem",1,2));
        problems.add(new Problem(3,"A + B Problem",1,2));
        problems.add(new Problem(4,"A - B Problem",1,2));
        model.addAttribute("room","problemlist");
        model.addAttribute("problemlist",problems);
        return "problemlist";
    }
    @RequestMapping("/profile")
    public String profile(){
        return "profile";
    }
}
