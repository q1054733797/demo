package com.demo.springboot;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test13
 * @date : Create in 2019/9/20 17:04
 */
public class Test13 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/test.txt");
        String str = FileUtils.readFileToString(file, "GBK");
        str = str + str;
        String[] split = str.split(",");
        System.out.println(split.length);
        StringBuilder builder = new StringBuilder();
        builder.append(str);
        System.out.println(builder.toString());
    }
}
