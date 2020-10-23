package com.gerayking.gerayoj.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;

@Controller
@RequestMapping("/problem")
public class ProblemController {
    private static String PROBLEN_PATH = "/home/geray/IdeaProjects/LJKZ-OJ/gerayoj/src/main/resources/static/md/";
    @RequestMapping(value = "/{pid}")
    public String problem(@PathVariable Integer pid,
                          Model model) throws IOException {
        String problemName = PROBLEN_PATH + String.valueOf(pid)+".md";
        File file = new File(problemName);
        Long fileLenth = file.length();
        FileInputStream inputStream = new FileInputStream(file);
        byte[] filecontent = new byte[fileLenth.intValue()];
        inputStream.read(filecontent);
        String s = new String(filecontent);
        System.out.println(s);
        model.addAttribute("room","problemlist");
        model.addAttribute("problemContent",s);
        return "problem";
    }
}
