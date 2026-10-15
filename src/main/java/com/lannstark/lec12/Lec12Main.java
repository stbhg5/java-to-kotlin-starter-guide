package com.lannstark.lec12;

import com.jint.lec12.Person;

public class Lec12Main {

    public static void main(String[] args) {
        // 정적 팩토리 메서드
        JavaPerson.newBaby("송진성");

        // Java 에서 Kotlin 의 companion object 를 사용
        // 동반 객체 이름 없을 때
        // Person.Companion.newBaby("A"); // @JvmStatic 없을 때
        Person.newBaby("A"); // @JvmStatic 있을 때
        // 동반 객체 이름 있을 때
        Person.Factory.newBaby("A");

        // 익명 클래스 사용
        moveSomething(new Movable() {
            @Override
            public void move() { System.out.println("움직인다~~"); }

            @Override
            public void fly() { System.out.println("난다~~"); }
        });
    }

    private static void moveSomething(Movable movable) {
        movable.move();
        movable.fly();
    }

}