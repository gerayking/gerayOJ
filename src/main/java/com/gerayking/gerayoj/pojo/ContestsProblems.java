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
public class ContestsProblems implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 问题id
     */
    private Integer problemId;

    /**
     * 对应的比赛的id
     */
    private Integer contestId;


}
