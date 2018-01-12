package com.bean;

import javax.xml.bind.annotation.*;

/**
 * @author aiboleepro
 * @date 2018-01-12 上午10:00
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "BankParam", propOrder = { "bankId", "userId", "tradeNo"})
public class BankParam {

    @XmlElement
    private String bankId;
    @XmlElement
    private String userId;
    @XmlElement
    private String tradeNo;

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

    @Override
    public String toString() {
        return "BankParam{" +
                "bankId='" + bankId + '\'' +
                ", userId='" + userId + '\'' +
                ", tradeNo='" + tradeNo + '\'' +
                '}';
    }
}
