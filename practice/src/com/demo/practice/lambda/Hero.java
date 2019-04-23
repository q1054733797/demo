package com.demo.practice.lambda;

/**
 * @ClassName: Hero
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/19 9:39
 * @Version: 1.0
 */
public class Hero {
    private String name;
    private int hp;
    private int damage;

    public Hero(){

    }

    public Hero(String name, int hp, int damage) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }
}
