package com.training.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户经验实体
 * 表名 game_user_experience
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:44
 */
public class GameUserExperienceEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //用户id
    private Long gameUserId;
    //用户经验
    private Long experience;
    //
    private Integer grade;
    //
    private Date gmtModified;
    //
    private Date gmtCreate;

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
     * 设置：用户id
     */
    public void setGameUserId(Long gameUserId) {
        this.gameUserId = gameUserId;
    }

    /**
     * 获取：用户id
     */
    public Long getGameUserId() {
        return gameUserId;
    }
    /**
     * 设置：用户经验
     */
    public void setExperience(Long experience) {
        this.experience = experience;
    }

    /**
     * 获取：用户经验
     */
    public Long getExperience() {
        return experience;
    }
    /**
     * 设置：
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 获取：
     */
    public Integer getGrade() {
        return grade;
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
