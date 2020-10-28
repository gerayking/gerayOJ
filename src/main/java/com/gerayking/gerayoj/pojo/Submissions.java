package com.gerayking.gerayoj.pojo;

import java.util.Date;
import java.sql.Blob;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 提交表格
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Submissions implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 提交id
     */
    private Integer id;

    /**
     * 提交对应的问题id
     */
    private Integer problemId;

    /**
     * 提交对应的比赛id
     */
    private Integer contestId;

    /**
     * 提交时间
     */
    private Date submitTime;

    /**
     * 提交用户名
     */
    private String submitter;

    /**
     * 提交的代码
     */
    private String content;

    /**
     * 提交的语言
     */
    private String languages;

    private Integer totSize;

    /**
     * 评测时间
     */
    private Date judgeTime;

    private Blob result;

    /**
     * 评测状态
     */
    private String submitStatus;

    /**
     * 错误信息
     */
    private String resultError;

    /**
     * 提交得分
     */
    private Integer score;

    /**
     * 使用时间
     */
    private Integer usedTime;

    /**
     * 使用内存
     */
    private Integer usedMemory;

    /**
     * 是否隐藏提交状态,赛后不隐藏
     */
    private Boolean isHidden;

    /**
     * 提交的细节信息
     */
    private String statusDetails;


}
