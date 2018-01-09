package com.polypeptide;

/**
 * 货车
 * @author aiboleepro
 * @date 2018-01-08 下午12:38
 **/
public class Trucks extends Car {

    private Double carry;

    Double getCarry() {
        return carry;
    }

    public void setCarry(Double carry) {
        this.carry = carry;
    }

    @Override
    void show() {
        System.out.println("我是货车 id:" + super.getId() + " | 价格: " + super.getPrice() + " | 载货量:" + this.getCarry());
    }

    @Override
    Double rent(int day) {
        return day * super.getPrice();
    }
}
