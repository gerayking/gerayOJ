package com.gerayking.gerayoj.service;

import com.gerayking.gerayoj.pojo.Contest;
import com.gerayking.gerayoj.pojo.ContestQuestion;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 提赛问题 服务类
 * </p>
 *
 * @author gerayKing
 * @since 2020-11-10
 */
@Service
public interface ContestQuestionService extends IService<ContestQuestion> {
    List<ContestQuestion> getContestQuestionById(int cid);
}
