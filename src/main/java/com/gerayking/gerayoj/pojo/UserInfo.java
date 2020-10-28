package com.gerayking.gerayoj.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户所属的组,管理组和用户组
管理组为'M',用户组为'U'
     */
    private String usergroup;

    /**
     * 用户名称
     */
    private String username;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户积分排名
     */
    private Integer rating;

    /**
     * 用户qq帐号
     */
    private Long qq;

    /**
     * 用户的性别
     */
    private String sex;

    /**
     * 该用户的AC数量
     */
    private Integer acNum;

    /**
     * 用户的注册时间
     */
    private Date registerTime;

    /**
     * 用户的地址
     */
    private String remoteAddr;

    /**
     * 用户的token
     */
    private String rememberToken;

    /**
     * 用户的座右铭
     */
    private String motto;


}
