package com.gerayking.gerayoj.mapper;

import com.gerayking.gerayoj.pojo.Contests;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gerayking.gerayoj.pojo.Problems;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Repository
public interface ContestsMapper extends BaseMapper<Contests> {
    @Select("select problem_id from contests_problems where contest_id = #{cid}")
    public List<Integer> getContestProblem(@Param("cid") int cid);
}
