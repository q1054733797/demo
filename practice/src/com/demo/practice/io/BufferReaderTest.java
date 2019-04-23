package com.demo.practice.io;

import java.io.*;

/**
 * @ClassName: BufferReaderTest
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/19 9:28
 * @Version: 1.0
 */
public class BufferReaderTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/practice.txt");
        if(file.exists()){
            Reader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            System.out.println(br.readLine());
        }
    }
}
