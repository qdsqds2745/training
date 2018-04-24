package com.training.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 training_class_type
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
public class ClassTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //班级名字
    private String className;
    //计费方式
    private Integer bilingId;
    //
    private Date startTime;
    //
    private Date endTime;
    //创建时间
    private Date gmtCreate;
    //实时修改事件
    private Date gmtModified;
    //备注
    private String remark;

    /**
     * 设置：
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Long getId() {
        return id;
    }
    /**
     * 设置：班级名字
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 获取：班级名字
     */
    public String getClassName() {
        return className;
    }
    /**
     * 设置：计费方式
     */
    public void setBilingId(Integer bilingId) {
        this.bilingId = bilingId;
    }

    /**
     * 获取：计费方式
     */
    public Integer getBilingId() {
        return bilingId;
    }
    /**
     * 设置：
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取：
     */
    public Date getStartTime() {
        return startTime;
    }
    /**
     * 设置：
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取：
     */
    public Date getEndTime() {
        return endTime;
    }
    /**
     * 设置：创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取：创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }
    /**
     * 设置：实时修改事件
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取：实时修改事件
     */
    public Date getGmtModified() {
        return gmtModified;
    }
    /**
     * 设置：备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取：备注
     */
    public String getRemark() {
        return remark;
    }
}
