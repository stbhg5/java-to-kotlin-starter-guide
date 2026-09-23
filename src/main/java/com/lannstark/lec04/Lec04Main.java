package com.lannstark.lec04;

import com.lannstark.lec04.JavaMoney;

public class Lec04Main {

    public static void main(String[] args) {
        // compareTo
        JavaMoney money1 = new JavaMoney(2_000L);
        JavaMoney money2 = new JavaMoney(1_000L);

        if (money1.compareTo(money2) > 0) {
            System.out.println("Money1이 Money2보다 금액이 큽니다");
        }

        // 동일성, 동등성
        JavaMoney money3 = new JavaMoney(1_000L);
        JavaMoney money4 = money3;
        JavaMoney money5 = new JavaMoney(1_000L);

        System.out.println(money3 == money4); // true
        System.out.println(money3 == money5); // false
        System.out.println(money3.equals(money5)); // true

        // 연산자 오버로딩
        JavaMoney money6 = new JavaMoney(1_000L);
        JavaMoney money7 = new JavaMoney(2_000L);

        System.out.println(money6.plus(money7));
    }

}