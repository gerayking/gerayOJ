package com.gerayking.gerayoj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gerayking.gerayoj.pojo.ContestQuestion;
import com.gerayking.gerayoj.mapper.ContestQuestionMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gerayking.gerayoj.service.ContestQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 提赛问题 服务实现类
 * </p>
 *
 * @author gerayKing
 * @since 2020-11-11
 */
@Service
public class ContestQuestionServiceImpl extends ServiceImpl<ContestQuestionMapper, ContestQuestion> implements ContestQuestionService {

    @Autowired
    ContestQuestionMapper contestQuestionMapper;

    @Override
    public List<ContestQuestion> getContestQuestionById(int cid) {
        QueryWrapper<ContestQuestion> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("contest_id",cid);
        List<ContestQuestion> questions = contestQuestionMapper.selectList(queryWrapper);
        return questions;
    }
}
