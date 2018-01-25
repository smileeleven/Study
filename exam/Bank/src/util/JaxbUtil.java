package util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

/**
 * @author aiboleepro
 * @date 2018-01-11 下午6:59
 **/
public class JaxbUtil {

    /**
     * 文件中xml转换成JavaBean
     *
     * @param path
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertFileXmlToJavaBean(String path, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            Object obj = unmarshaller.unmarshal(fileInputStream);
            if (c.isInstance(obj)) {
                t = (T) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }

    /**
     * JavaBean转换成xml并保存到文件
     *
     * @param obj
     * @param path
     */
    public static void convertToXml(Object obj, String path) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 决定是否在转换成xml时同时进行格式化（即按标签自动换行，否则即是一行的xml）
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // xml的编码方式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            marshaller.marshal(obj, fileOutputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * JavaBean转换成xml
     *
     * @param obj
     * @return
     */
    public static String convertToXml(Object obj) {
        String result = null;
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());
            Marshaller marshaller = context.createMarshaller();
            // 决定是否在转换成xml时同时进行格式化（即按标签自动换行，否则即是一行的xml）
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            // xml的编码方式
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, writer);
            result = writer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * xml转换成JavaBean
     *
     * @param xml
     * @param c
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T convertToJavaBean(String xml, Class<T> c) {
        T t = null;
        try {
            JAXBContext context = JAXBContext.newInstance(c);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object obj = unmarshaller.unmarshal(new StringReader(xml));
            if (c.isInstance(obj)) {
                t = (T) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t;
    }
}
