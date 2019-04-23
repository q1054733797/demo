package com.demo.practice.io;

import java.io.*;

/**
 * @ClassName: TestFile
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/19 9:07
 * @Version: 1.0
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/practice.txt");
        if(file.exists()){
            System.out.println("绝对路径：" + file.getAbsolutePath());
            InputStream is = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            is.read(bytes);
            System.out.println(new String(bytes));
        }
    }
}
