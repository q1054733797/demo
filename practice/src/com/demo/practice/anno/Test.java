package com.demo.practice.anno;

/**
 * @ClassName: Test
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/21 9:37
 * @Version: 1.0
 */
@User(username = "zhanghongkai",password = "123456",name="张鸿凯")
public class Test {
    public static void main(String[] args) {
        User user = Test.class.getAnnotation(User.class);
        System.out.println(user.username());
        System.out.println(user.password());
        System.out.println(user.name());
        System.out.println(user.sax());
    }
}
