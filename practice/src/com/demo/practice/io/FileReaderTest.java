package com.demo.practice.io;

import java.io.*;

/**
 * @ClassName: FileReaderTest
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/19 9:20
 * @Version: 1.0
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/practice.txt");
        if(file.exists()){
            Reader reader = new FileReader(file);
            char[] chars = new char[(int)file.length()];
            reader.read(chars);
            System.out.println(java.lang.String.copyValueOf(chars));
        }
    }
}
