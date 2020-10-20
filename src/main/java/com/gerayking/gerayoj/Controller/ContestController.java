package com.gerayking.gerayoj.Controller;

import com.gerayking.gerayoj.pojo.Contest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping("/contest")
public class ContestController {
    @RequestMapping("/")
    public String index(Model model){
        Contest contest = new Contest();
        contest.setCID(1);
        contest.setDescription("hello world");
        contest.setTitle("INININ");
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(2);
        integers.add(3);
        integers.add(4);
        SimpleDateFormat sdf = new SimpleDateFormat("mm-dd HH:mm");
        contest.setStartTime(sdf.format(new Date(System.currentTimeMillis())));
        contest.setEndTime(sdf.format(new Date(System.currentTimeMillis()+1000*60*60*5)));
        contest.setProblemList(integers);
        ArrayList<Contest> contests = new ArrayList<>();
        contests.add(contest);
        model.addAttribute("contests",contests);
        model.addAttribute("room","contests");
        return "contests";
    }
}
