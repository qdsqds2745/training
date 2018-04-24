package com.training.entity;

import java.io.Serializable;
import java.util.Date;


/**
 * 会员实体
 * 表名 training_member
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
public class MemberEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //会员名字
    private String memberName;
    //会员密码
    private String memberPassword;
    //手机号
    private String phone;
    //机构id
    private Integer organizationId;
    //
    private Date gmtCreate;
    //
    private Date gmtModified;

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
     * 设置：会员名字
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * 获取：会员名字
     */
    public String getMemberName() {
        return memberName;
    }
    /**
     * 设置：会员密码
     */
    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    /**
     * 获取：会员密码
     */
    public String getMemberPassword() {
        return memberPassword;
    }
    /**
     * 设置：手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取：手机号
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 设置：机构id
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取：机构id
     */
    public Integer getOrganizationId() {
        return organizationId;
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
}
