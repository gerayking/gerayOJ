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
public class ProblemsTags implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标签id
     */
    private Integer id;

    /**
     * 问题id
     */
    private Integer problemId;

    /**
     * 标签名称
     */
    private String tag;


}
