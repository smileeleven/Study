package com.i2finance.entity;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 * 小组实体类
 *
 * @author aiboleepro
 * @date 2018-01-12 下午2:15
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "group")
@XmlType(propOrder = { "id", "name","score","lastTime"})
public class Group {

    @XmlElement(name = "id")
    private String id;
    /**
     * 小组名称
     */
    @XmlElement(name = "name")
    private String name;
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
