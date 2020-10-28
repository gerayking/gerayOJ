package com.gerayking.gerayoj.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 比赛提交
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContestsSubmissions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 比赛id
     */
    private Integer contestId;

    /**
     * 提交的用户名
     */
    private String submitter;

    /**
     * 提交的问题id
     */
    private Integer problemId;

    /**
     * 提交的编号id
     */
    private Integer submissionId;

    /**
     * 获得的分数
     */
    private Integer score;

    /**
     * 罚时
     */
    private Integer penalty;


}
