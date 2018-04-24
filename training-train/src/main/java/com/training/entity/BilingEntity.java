package com.training.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 计费方式表实体
 * 表名 training_biling
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-03-20 09:51:04
 */
public class BilingEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer bilingId;
    //价格
    private BigDecimal pice;
    //课时或者学期
    private String hoursTerm;
    //创建时间
    private Date gmtCreate;
    //修改时间
    private Date gmtModified;

    /**
     * 设置：
     */
    public void setBilingId(Integer bilingId) {
        this.bilingId = bilingId;
    }

    /**
     * 获取：
     */
    public Integer getBilingId() {
        return bilingId;
    }
    /**
     * 设置：价格
     */
    public void setPice(BigDecimal pice) {
        this.pice = pice;
    }

    /**
     * 获取：价格
     */
    public BigDecimal getPice() {
        return pice;
    }
    /**
     * 设置：课时或者学期
     */
    public void setHoursTerm(String hoursTerm) {
        this.hoursTerm = hoursTerm;
    }

    /**
     * 获取：课时或者学期
     */
    public String getHoursTerm() {
        return hoursTerm;
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
     * 设置：修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取：修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }
}
