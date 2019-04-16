package com.demo.shiro.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @ClassName: PryptographyUtil
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/16 9:03
 * @Version: 1.0
 */
public class PryptographyUtil {
    public static String encodeBase64(String str){
        return Base64.encodeToString(str.getBytes());
    }

    public static String decodeBase64(String str){
        return Base64.decodeToString(str);
    }

    public static String encodeMd5(String str, String salt,int time){
        return new Md5Hash(str,salt,time).toString();
    }

    public static String encodeMd5(String str, String salt){
        return new Md5Hash(str,salt).toString();
    }

    public static String encodeMd5(String str){
        return new Md5Hash(str).toString();
    }
}
