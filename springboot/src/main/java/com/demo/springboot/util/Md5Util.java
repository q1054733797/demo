package com.demo.springboot.util;

import com.demo.springboot.pojo.Student;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.util.DigestUtils;
import sun.security.provider.MD5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @ClassName: Md5Util
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 11:25
 * @Version: 1.0
 */
public class Md5Util {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(md5Encode("admin123456"));
    }
    public static String md5Encode(String str) throws NoSuchAlgorithmException {
        //String md5 = DigestUtils.md5DigestAsHex(str.getBytes());
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(str.getBytes());
        String string = new BigInteger(1, md5.digest()).toString(16);
        return string;
    }
}
