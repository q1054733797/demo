package com.demo.practice.test;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test02
 * @date : Create in 2019/9/24 20:18
 */
public class Test02 {
    public static void main(String[] args) {
        Test15Service service = new Test15Service();
        Test15 test15 = service.getTest15Port();
        System.out.println(test15.test01());
    }
}
