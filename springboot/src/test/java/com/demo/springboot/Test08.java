package com.demo.springboot;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName : Test08
 * @author : zhanghongkai
 * @date : Create in 2019/8/30 21:54
 * @version : 1.0
 */
public class Test08 {
    /**
    *@Description :
    *@author : zhanghongkai
    *@date : 2019/9/3 11:00
    *@param
    *@return :
    */
    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read(new File("F:/test.xml"));
        Element rootElement = document.getRootElement();
        Iterator iterator = rootElement.elementIterator();
        while (iterator.hasNext()){
            Element element = (Element)iterator.next();
            System.out.println(element.getText());
            List attributes = element.attributes();
            for (Object attribute : attributes) {
                System.out.println(((Attribute)attribute).getValue());
            }
        }
    }
}
