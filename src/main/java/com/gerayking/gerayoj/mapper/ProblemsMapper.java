package com.gerayking.gerayoj.mapper;

import com.gerayking.gerayoj.pojo.Problems;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 题目表 Mapper 接口
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Repository
@Mapper
public interface ProblemsMapper extends BaseMapper<Problems> {

}
