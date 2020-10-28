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
public class Contests implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 比赛表示id

     */
    private Integer id;

    /**
     * 比赛名称
     */
    private String name;

    /**
     * 比赛开始时间
     */
    private Date startTime;

    /**
     * 持续时间
     */
    private Integer lastMin;

    /**
     * 参赛人数
     */
    private Integer playerNum;

    /**
     * 当前状态
     */
    private String status;


}
