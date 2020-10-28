package com.gerayking.gerayoj.controller;


import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gerayking.gerayoj.mapper.ProblemsMapper;
import com.gerayking.gerayoj.pojo.Problems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 题目表 前端控制器
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Controller
public class ProblemsController {
    @Autowired
    ProblemsMapper problemsMapper;
    @RequestMapping({"/problemlist","/problemlist/{pid}"})
   public String prolemlist(@PathVariable(required = false) Integer pid,
                            Model model){
        if(pid==null)pid = 1;
        Page<Problems> page = new Page<>(pid, 20);
        problemsMapper.selectPage(page,null);
        List<Problems> problems = page.getRecords();
        long total = page.getTotal();
        long current = page.getCurrent();
        long pagemin = Math.max(current-3,1);
        long pagemax = Math.min(current+3,total);
        model.addAttribute("pager",page);
        model.addAttribute("problems",problems);
        model.addAttribute("currentPage",current);
        model.addAttribute("pagemin",pagemin);
        model.addAttribute("pagemax",pagemax);
        return "problemlist";
    }
}

