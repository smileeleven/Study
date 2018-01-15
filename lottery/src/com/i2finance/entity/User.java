package com.i2finance.entity;


import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Date;

/**
 * 用户实体类
 *
 * @author aiboleepro
 * @date 2018-01-09 下午7:44
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
@XmlType(propOrder = { "id", "groupId","name","face","score","lastTime"})
public class User {

    @XmlElement(name = "id")
    private String id;
    /**
     * 所属的小组id
     * */
    @XmlElement(name = "groupId")
    private String groupId;
    /**
     * 姓名
     */
    @XmlElement(name = "name")
    private String name;
    /**
     * 头像
     */
    @XmlElement(name = "face")
    private String face;
    /**
     * 当前积分
     */
    @XmlElement(name = "score")
    private Integer score;
    /**
     * 最近一次被抽中的时间
     */
    @XmlElement(name = "lastTime")
    private Date lastTime;


}
