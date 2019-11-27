package com.demo.practice.io;

import java.io.*;

/**
 * @author : zhanghongkai
 * @version : 1.0
 * @ClassName : Test01
 * @date : Create in 2019/10/17 20:46
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/test.txt");
        Writer writer = new FileWriter(file);
        writer.append("123\r\n");
        writer.append("456\r\n");
        writer.flush();
    }
}
