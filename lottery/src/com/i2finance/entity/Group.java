package com.i2finance.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 小组实体类
 *
 * @author aiboleepro
 * @date 2018-01-12 下午2:15
 **/
@Data
public class Group {

    private String id;
    /**
     * 小组名称
     */
    private String name;
    /**
     * 小组成员
     */
    private List<User> user;
    /**
     * 当前积分
     */
    private Integer score;
    /**
     * 最近一次被抽中的时间
     */
    private Date lastTime;
}
