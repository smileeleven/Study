package com.xml;

import java.util.Date;

/**
 * @author aiboleepro
 * @date 2018-01-11 下午7:08
 **/
public class JaxbTest {

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(100);
        book.setAuthor("James");
        book.setCalendar(new Date());
        book.setPrice(23.45f);

        String str = JaxbUtil.convertToXml(book);
        System.out.println(str);

        String str1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<book id=\"100\">" +
                "    <author>James</author>" +
                "   <calendar>2013-03-29T09:25:56.004+08:00</calendar>" +
                "  <price_1>23.45</price_1>" +
                "</book>";
        Book book1 = JaxbUtil.convertToJavaBean(str1, Book.class);
        System.out.println(book1);
    }
}
