package com.gerayking.gerayoj.service.impl;

import com.gerayking.gerayoj.pojo.UserInfo;
import com.gerayking.gerayoj.mapper.UserInfoMapper;
import com.gerayking.gerayoj.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
