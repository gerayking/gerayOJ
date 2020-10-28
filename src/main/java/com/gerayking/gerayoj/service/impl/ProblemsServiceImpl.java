package com.gerayking.gerayoj.service.impl;

import com.gerayking.gerayoj.pojo.Problems;
import com.gerayking.gerayoj.mapper.ProblemsMapper;
import com.gerayking.gerayoj.service.ProblemsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 题目表 服务实现类
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Service
public class ProblemsServiceImpl extends ServiceImpl<ProblemsMapper, Problems> implements ProblemsService {

}
