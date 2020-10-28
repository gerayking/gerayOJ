package com.gerayking.gerayoj.controller;

import com.gerayking.gerayoj.mapper.ProblemsMapper;
import com.gerayking.gerayoj.pojo.Problems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.*;

@Controller
@RequestMapping("/problem")
public class ProblemController {
    @Autowired
    ProblemsMapper problemsMapper;
    @RequestMapping(value = "/{pid}")
    public String problem(@PathVariable Integer pid,
                          Model model) throws IOException {
        Problems problems = problemsMapper.selectById(pid);
        model.addAttribute("problem",problems);
        return "problem";
    }
}
