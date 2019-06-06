package com.demo.springboot.pojo;

/**
 * @ClassName: Student
 * @Author: zhanghongkai
 * @Date: Create in 2019/6/5 10:50
 * @Version: 1.0
 */
public class Student {
    private int id;
    private int score;
    private int age;
    private String name;
    private String course;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", score=" + score +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
