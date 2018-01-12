package com.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author aiboleepro
 * @date 2018-01-11 上午10:35
 **/
public class XmlUtil {

    private static Document getDocument(String filepath){
        try {
            SAXReader reader = new SAXReader();
            return reader.read(new File(filepath));
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Document getDocumentFromText(String text){
        try {
            return DocumentHelper.parseText(text);
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String,String> parseParam(String param){
        Element root = getDocumentFromText(param).getRootElement();
        String bankId = root.element("bankId").getTextTrim();
        String userId = root.element("userId").getTextTrim();
        Map<String,String> map = new HashMap<>(2);
        map.put("bankId",bankId);
        map.put("userId",userId);
        return map;
    }

    public static String parseBank(String bankId, String userId){
        Element root = getDocument("/Users/aiboleepro/IdeaProjects/Study/study/src/com/xml/bank.xml").getRootElement();
        List<Element> banks = root.elements("bank");
        Element bank = null;
        for(Element element : banks){
            if(element.attribute("id").getValue().equals(bankId)){
                bank = element;
                break;
            }
        }
        if(bank == null){
            throw new RuntimeException("找不到相应银行");
        }
        List<Element> users = bank.elements("user");
        Element user = null;
        for(Element element : users){
            if(element.attribute("id").getValue().equals(userId)){
                user = element;
            }
        }
        if(user == null){
            throw new RuntimeException("找不到相应用户");
        }
        return user.element("money").getTextTrim();
    }

}
