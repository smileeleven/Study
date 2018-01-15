package com.i2finance.entity;


import lombok.Data;

import java.util.Date;

/**
 * 用户实体类
 *
 * @author aiboleepro
 * @date 2018-01-09 下午7:44
 **/
@Data
public class User {

    private String id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 头像
     */
    private String face;
    /**
     * 当前积分
     */
    private Integer score;
    /**
     * 最近一次被抽中的时间
     */
    private Date lastTime;


}
