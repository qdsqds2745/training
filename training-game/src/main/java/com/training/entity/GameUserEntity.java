package com.training.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 实体
 * 表名 game_user
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
public class GameUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //
    private String username;
    //
    private String mobile;
    //
    private Date gmtCreate;
    //
    private Date gmtModified;
    //状态0正常1 2 3待定
    private String status;

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
     * 设置：
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取：
     */
    public String getUsername() {
        return username;
    }
    /**
     * 设置：
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取：
     */
    public String getMobile() {
        return mobile;
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
     * 设置：状态0正常1 2 3待定
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取：状态0正常1 2 3待定
     */
    public String getStatus() {
        return status;
    }
}
