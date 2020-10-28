package com.gerayking.gerayoj.pojo;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 题目表
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Problems implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 题目id
     */
    private Integer id;

    /**
     * 题目的标题
     */
    private String title;

    /**
     * 题目的体面描述,采用markdown格式,支持Katex
     */
    private String statement;

    /**
     * 是否可见,有些题目需要赛后可见
     */
    private Boolean isHidden;

    /**
     * 通过此题的人数
     */
    private Integer acNum;

    /**
     * 提交的次数
     */
    private Integer submitNum;

    /**
     * 时间限制
     */
    private Integer timelimit;

    /**
     * 内存限制,单位kb
     */
    private Integer memorylimit;


}
