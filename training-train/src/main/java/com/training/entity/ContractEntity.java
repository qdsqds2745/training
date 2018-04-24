package com.training.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 合同实体
 * 表名 training_contract
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:43
 */
public class ContractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //会员id
    private Long memberId;
    //课类型
    private Long classTypeId;
    //会员名字
    private String memberName;
    //课时或学期价格
    private BigDecimal hoursPice;
    //课时或学期次数
    private Integer hoursNumber;
    //
    private String hoursTerm;
    //
    private Date gmtCreate;
    //总价
    private BigDecimal total;
    //合同状态
    private String stauts;
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
     * 设置：会员id
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    /**
     * 获取：会员id
     */
    public Long getMemberId() {
        return memberId;
    }
    /**
     * 设置：课类型
     */
    public void setClassTypeId(Long classTypeId) {
        this.classTypeId = classTypeId;
    }

    /**
     * 获取：课类型
     */
    public Long getClassTypeId() {
        return classTypeId;
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
     * 设置：课时或学期价格
     */
    public void setHoursPice(BigDecimal hoursPice) {
        this.hoursPice = hoursPice;
    }

    /**
     * 获取：课时或学期价格
     */
    public BigDecimal getHoursPice() {
        return hoursPice;
    }
    /**
     * 设置：课时或学期次数
     */
    public void setHoursNumber(Integer hoursNumber) {
        this.hoursNumber = hoursNumber;
    }

    /**
     * 获取：课时或学期次数
     */
    public Integer getHoursNumber() {
        return hoursNumber;
    }
    /**
     * 设置：
     */
    public void setHoursTerm(String hoursTerm) {
        this.hoursTerm = hoursTerm;
    }

    /**
     * 获取：
     */
    public String getHoursTerm() {
        return hoursTerm;
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
     * 设置：总价
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * 获取：总价
     */
    public BigDecimal getTotal() {
        return total;
    }
    /**
     * 设置：合同状态
     */
    public void setStauts(String stauts) {
        this.stauts = stauts;
    }

    /**
     * 获取：合同状态
     */
    public String getStauts() {
        return stauts;
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
