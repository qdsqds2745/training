package com.training.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 用户账户实体
 * 表名 game_user_accounts
 *
 * @author tongchunbin
 * @email 1533961990@qq.com
 * @date 2018-04-09 22:17:44
 */
public class GameUserAccountsEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Long id;
    //用户id
    private Long gameUserId;
    //硬币
    private BigDecimal coin;
    //充值的钱
    private BigDecimal moneyToPay;
    //
    private Date gmtModified;
    //
    private Date gmtCreate;
    //账户可用余额
    private BigDecimal balance;

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
     * 设置：硬币
     */
    public void setCoin(BigDecimal coin) {
        this.coin = coin;
    }

    /**
     * 获取：硬币
     */
    public BigDecimal getCoin() {
        return coin;
    }
    /**
     * 设置：充值的钱
     */
    public void setMoneyToPay(BigDecimal moneyToPay) {
        this.moneyToPay = moneyToPay;
    }

    /**
     * 获取：充值的钱
     */
    public BigDecimal getMoneyToPay() {
        return moneyToPay;
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
    /**
     * 设置：账户可用余额
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 获取：账户可用余额
     */
    public BigDecimal getBalance() {
        return balance;
    }
}
