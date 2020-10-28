package com.gerayking.gerayoj;

import com.gerayking.gerayoj.mapper.ContestsMapper;
import com.gerayking.gerayoj.pojo.Contests;
import com.sun.org.apache.bcel.internal.generic.ACONST_NULL;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class GerayojApplicationTests {

    @Autowired
    ContestsMapper contestsMapper;
    @Test
    void contextLoads() {
        Contests contests = new Contests();
        contests.setId(1);
        contests.setName("第一次Geayking比赛");
        contests.setStartTime(new Date());
        contests.setLastMin(300);
        contests.setStatus("未开始");
        contests.setPlayerNum(0);
        contestsMapper.insert(contests);
    }

}
