package com.polypeptide;

/**
 * @author aiboleepro
 * @date 2018-01-08 下午12:35
 **/
abstract class Car {

    private int id;
    private String name;
    private Double price;

    abstract void show();

    abstract Double rent(int day);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
