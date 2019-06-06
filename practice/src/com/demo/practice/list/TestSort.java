package com.demo.practice.list;

import java.util.*;

/**
 * @ClassName: TestSort
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/4 11:29
 * @Version: 1.0
 */
public class TestSort {
    public static void main(String[] args) {
        HashMap<Integer,User> map = new HashMap<>();
        map.put(1, new User(25, "张三"));
        map.put(3, new User(22, "李四"));
        map.put(2, new User(28, "王五"));
        System.out.println(map);
        map = sortMap(map);
        System.out.println(map);
    }

    public static HashMap<Integer,User> sortMap(HashMap<Integer,User> map){
        Set<Map.Entry<Integer, User>> set = map.entrySet();
        List<Map.Entry<Integer, User>> list = new ArrayList<>(set);
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge() - o1.getValue().getAge();
            }
        });
        LinkedHashMap<Integer, User> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, User> temp : list) {
            linkedHashMap.put(temp.getKey(), temp.getValue());
        }
        return linkedHashMap;
    }
}
