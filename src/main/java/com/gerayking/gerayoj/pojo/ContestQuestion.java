package com.gerayking.gerayoj.pojo;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 提赛问题
 * </p>
 *
 * @author gerayKing
 * @since 2020-11-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ContestQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer contestId;

    /**
     * 提问内容
     */
    private String content;

    /**
     * 问题回答
     */
    private String answer;

    /**
     * 提问的人

     */
    private String questionerName;

    @TableField("Time")
    private Date Time;


}
