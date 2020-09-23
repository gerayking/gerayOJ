package com.gerayking.gerayoj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class IndexController {
    @RequestMapping("/test")
    @ResponseBody
    public String index(){
            return "index";
    }
    @GetMapping("index  ")
    public String goindex(){return "index";}
}
