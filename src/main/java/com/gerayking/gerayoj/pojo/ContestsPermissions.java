package com.gerayking.gerayoj.pojo;

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
public class ContestsPermissions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 是否允许参加比赛
     */
    private Integer contestId;


}
