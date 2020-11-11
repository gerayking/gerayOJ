package com.gerayking.gerayoj.config;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gerayking.gerayoj.mapper.UserInfoMapper;
import com.gerayking.gerayoj.pojo.UserInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserInfoMapper userInfoMapper;
    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    // 认证
    /**
     * 功能描述:
     *  这个函数是交给开发人员进行业务开发的接口,前端加密好的token传过来后,进行解密
     *  然后开发人员调用数据库查出对应的密码,然后交给Shiro进行验证............
     * @param authenticationToken 加密后的令牌
     * @return 验证的信息
     * @auther gerayking
     * @date  2020/10/19 下午8:15
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String)authenticationToken.getPrincipal();
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        UserInfo user = userInfoMapper.selectOne(queryWrapper);
        String password = user.getPassword();
        return new SimpleAuthenticationInfo(username,password,getName());
    }
}
