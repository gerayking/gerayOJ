package com.gerayking.gerayoj.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gerayking.gerayoj.mapper.ContestsMapper;
import com.gerayking.gerayoj.mapper.ContestsProblemsMapper;
import com.gerayking.gerayoj.pojo.Contests;
import com.gerayking.gerayoj.pojo.ContestsProblems;
import com.gerayking.gerayoj.pojo.Problems;
import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Controller
@RequestMapping("/contestlist")
public class ContestsController {
    @Autowired
    ContestsMapper contestsMapper;
    @RequestMapping("/{cid}")
    public String contestlist(@PathVariable Integer cid,
                              Model model){
        if(cid==null)cid = 1;
        Page<Contests> page = new Page<>(cid, 20);
        contestsMapper.selectPage(page,null);
        List<Contests> contests = page.getRecords();
        long total = page.getTotal();
        long current = page.getCurrent();
        long pagemin = Math.max(current-3,1);
        long pagemax = Math.min(current+3,total);
        model.addAttribute("pager",page);
        model.addAttribute("contests",contests);
        model.addAttribute("currentPage",current);
        model.addAttribute("pagemin",pagemin);
        model.addAttribute("pagemax",pagemax);
        return "contestlist";
    }
}

