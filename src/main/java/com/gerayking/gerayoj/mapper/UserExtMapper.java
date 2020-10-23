package com.gerayking.gerayoj.mapper;

import com.gerayking.gerayoj.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserExtMapper {
    List<User> selectByEamilOrUsername(User user);
}
