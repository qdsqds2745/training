package com.training.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 grade
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
public class GradeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //等级的级数
    private Integer series;
    //达到series等级的经验
    private Long experience;
    //
    private Date gmtModified;
    //
    private Date gmtCreate;

    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：等级的级数
     */
    public void setSeries(Integer series) {
        this.series = series;
    }

    /**
     * 获取：等级的级数
     */
    public Integer getSeries() {
        return series;
    }
    /**
     * 设置：达到series等级的经验
     */
    public void setExperience(Long experience) {
        this.experience = experience;
    }

    /**
     * 获取：达到series等级的经验
     */
    public Long getExperience() {
        return experience;
    }
    /**
     * 设置：
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取：
     */
    public Date getGmtModified() {
        return gmtModified;
    }
    /**
     * 设置：
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取：
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }
}
