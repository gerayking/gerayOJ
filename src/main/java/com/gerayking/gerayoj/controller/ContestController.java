package com.gerayking.gerayoj.controller;

import com.gerayking.gerayoj.mapper.ContestsMapper;
import com.gerayking.gerayoj.mapper.ContestsProblemsMapper;
import com.gerayking.gerayoj.pojo.Contests;
import com.gerayking.gerayoj.pojo.ContestsProblems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping("/contest")
public class ContestController {
    @Autowired
    ContestsProblemsMapper contestsProblemsMapper;
    @Autowired
    ContestsMapper contestsMapper;
    @RequestMapping("/{cid}")
    public String contests(@PathVariable Integer cid,
                           Model model){
        Contests contests = contestsMapper.selectById(cid);
        HashMap<String, Object> map = new HashMap<>();
        map.put("contest_id",cid);
        List<ContestsProblems> problems = contestsProblemsMapper.selectByMap(map);
        model.addAttribute("contest",contests);
        model.addAttribute("problems",problems);
        return "contestlist";
    }
}
