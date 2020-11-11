package com.gerayking.gerayoj.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gerayking.gerayoj.mapper.ContestsMapper;
import com.gerayking.gerayoj.mapper.ContestsNoticeMapper;
import com.gerayking.gerayoj.mapper.ContestsProblemsMapper;
import com.gerayking.gerayoj.mapper.ProblemsMapper;
import com.gerayking.gerayoj.pojo.*;
import com.gerayking.gerayoj.service.ContestQuestionService;
import com.gerayking.gerayoj.service.impl.ContestQuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 * 比赛列表中的题目
 * @author gerayKing
 * @since 2020-10-28
 */
@Controller
public class ContestsProblemsController {
    @Autowired
    ContestsProblemsMapper contestsProblemsMapper;
    @Autowired
    ContestsMapper contestsMapper;
    @Autowired
    ProblemsMapper problemsMapper;
    @Autowired
    ContestsNoticeMapper contestsNoticeMapper;
    @Autowired
    ContestQuestionService contestQuestionService;
    @RequestMapping({"/contest/{cid}"})
    public String contestProblems(@PathVariable Integer cid,
                                  Model model){
        QueryWrapper<Problems> problemsQueryWrapper = new QueryWrapper<>();
        QueryWrapper<ContestsNotice> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("contest_id",cid);
        List<ContestsNotice> contestsNotices = contestsNoticeMapper.selectList(queryWrapper);
        List<Integer> problemIds = contestsMapper.getContestProblem(cid);
        Contests contests = contestsMapper.selectById(cid);
        problemsQueryWrapper.in("id",problemIds);
        List<Problems> problems = problemsMapper.selectList(problemsQueryWrapper);
        List<ContestQuestion> contestQuestions = contestQuestionService.getContestQuestionById(cid);
        model.addAttribute("contest",contests);
        model.addAttribute("problems",problems);
        model.addAttribute("contestsNotices",contestsNotices);
        model.addAttribute("contestQuestions",contestQuestions);
        return "contest";
    }
    @RequestMapping({"/contest/{cid}/problem/{pid}"})
    public String getcontestProblem(@PathVariable Integer cid,
                                    @PathVariable Integer pid,
                                    Model model){
        QueryWrapper<Problems> problemsQueryWrapper = new QueryWrapper<>();
        List<Integer> problemIds = contestsMapper.getContestProblem(cid);
        Contests contests = contestsMapper.selectById(cid);
        problemsQueryWrapper.in("id",problemIds);
        List<Problems> problems = problemsMapper.selectList(problemsQueryWrapper);
        int preid = -1, sufid = -1;
        for(int i=0;i<problems.size();i++){
            if(problems.get(i).getId() == pid){
                if (i!=0)preid=problems.get(i-1).getId();
                if(i!=problems.size()-1)sufid=problems.get(i+1).getId();
                break;
            }
        }
        Problems problem = problemsMapper.selectById(pid);
        model.addAttribute("problem",problem);
        model.addAttribute("contestid",cid);
        model.addAttribute("preid",preid);
        model.addAttribute("sufid",sufid);

        return "contestproblem";
    }
}

