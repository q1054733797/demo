package com.demo.practice.io;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @ClassName: TestFile
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/19 9:07
 * @Version: 1.0
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = new File("F:/test.txt");
        if(file.exists()){
            InputStream is = new FileInputStream(file);
            byte[] b = new byte[3];
            is.read(b);
            is.close();
            InputStreamReader reader = null;
            if ((b[0] == -17 && b[1] == -69 && b[2] == -65)||(b[0] == 50 && b[1] == 48 && b[2] == 49) ){
                System.out.println(file.getName() + "：编码为UTF-8");
                reader = new InputStreamReader(new FileInputStream(file), Charset.defaultCharset());
                BufferedReader br = new BufferedReader(reader);

                System.out.println( br.readLine());
            }else{
                System.out.println(file.getName() + "：可能是GBK，也可能是其他编码");
            }
            System.out.println("绝对路径：" + file.getAbsolutePath());

            byte[] bytes = new byte[(int)file.length()];
            is.read(bytes);
            System.out.println(new String(bytes));
        }
    }
}
