package com.demo.practice.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @ClassName: CreateFile
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/19 9:02
 * @Version: 1.0
 */
public class CreateFile {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/practice.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        String text = "HelloWorld,张鸿凯";
        OutputStream os = new FileOutputStream(file);
        os.write(text.getBytes());
        os.close();
    }
}
