package com.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author aiboleepro
 * @date 2018-01-11 下午7:07
 **/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
@XmlType(name = "book", propOrder = { "author", "calendar", "price", "id" })
public class Book implements Serializable{

    @XmlElement(required = true)
    private String author;

    @XmlElement(name = "price_1", required = true)
    private float price;

    @XmlElement
    private Date calendar;

    @XmlAttribute
    private Integer id;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Date getCalendar() {
        return calendar;
    }

    public void setCalendar(Date calendar) {
        this.calendar = calendar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", price=" + price +
                ", calendar=" + calendar +
                ", id=" + id +
                '}';
    }
}
