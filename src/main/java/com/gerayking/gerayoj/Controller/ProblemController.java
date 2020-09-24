package com.gerayking.gerayoj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/problem")
public class ProblemController {
    @RequestMapping("/{pid}")
    public String problem(@RequestParam(name = "pid",defaultValue = "0")int pid,
                          Model model){
        return "problem";
    }
}
