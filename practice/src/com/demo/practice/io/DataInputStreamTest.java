package com.demo.practice.io;

import java.io.*;

/**
 * @ClassName: DataInputStreamTest
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/19 9:33
 * @Version: 1.0
 */
public class DataInputStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/practice.txt");
        if(file.exists()){
            InputStream is = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readBoolean());
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());
        }
    }
}
