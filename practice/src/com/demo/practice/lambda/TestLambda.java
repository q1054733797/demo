package com.demo.practice.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName: TestLambda
 * @Author: zhanghongkai
 * @Date: Create in 2019/4/19 9:40
 * @Version: 1.0
 */
public class TestLambda {
    public static void main(String[] args) {
        List<Hero> heroes = new ArrayList<>();
        Random random = new Random();
        for(int i=0;i<10;i++){
            heroes.add(new Hero("hero" + i, random.nextInt(1000), random.nextInt(100)));
        }
        System.out.println("初始英雄");
        System.out.println(heroes);
        System.out.println("筛选hp>100,damage大于50的英雄");
        //filter(heroes);
//        IHeroChecker heroChecker = new IHeroChecker() {
//            @Override
//            public boolean test(Hero hero) {
//                return hero.getHp() > 100 && hero.getDamage() > 50;
//            }
//        };
        filter2(heroes,TestLambda::testHero);
    }

    public static void filter(List<Hero> heroes){
        for (Hero hero : heroes) {
            if(hero.getHp() > 100 && hero.getDamage() > 50){
                System.out.println(hero);
            }
        }
    }

    public static void filter2(List<Hero> heroes,IHeroChecker checker){
        for (Hero hero : heroes) {
            if(checker.test(hero)){
                System.out.println(hero);
            }
        }
    }

    public static boolean testHero(Hero hero){
        return hero.getHp() > 100 && hero.getDamage() > 50;
    }
}
