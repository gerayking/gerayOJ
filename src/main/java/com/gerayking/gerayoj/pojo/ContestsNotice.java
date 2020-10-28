package com.gerayking.gerayoj.pojo;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 比赛提醒
 * </p>
 *
 * @author gerayKing
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContestsNotice implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 比赛的id
     */
    private Integer contestId;

    /**
     * 比赛提醒的名称
     */
    private String title;

    /**
     * 比赛提醒的内容
     */
    private String content;

    /**
     * 比赛开始的时间
     */
    private Date time;


}
