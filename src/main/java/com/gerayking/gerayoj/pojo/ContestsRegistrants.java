package com.gerayking.gerayoj.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 比赛的注册表
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContestsRegistrants implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;

    /**
     * 参赛的用户积分
     */
    private Integer userRating;

    /**
     * 比赛的id
     */
    private Integer contestId;

    /**
     * 是否参加
     */
    private Boolean hasParticipated;

    /**
     * 排名
     */
    private Integer ranking;


}
