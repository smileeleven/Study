package com.bean;

import javax.xml.bind.annotation.*;

/**
 * @author aiboleepro
 * @date 2018-01-12 上午10:03
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "BankResult", propOrder = { "bankId", "userId", "tradeNo", "money"})
public class BankResult {

    @XmlElement
    private String bankId;

    @XmlElement
    private String userId;

    @XmlElement
    private String tradeNo;

    @XmlElement
    private Integer money;

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "BankResult{" +
                "bankId='" + bankId + '\'' +
                ", userId='" + userId + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                ", money=" + money +
                '}';
    }
}
