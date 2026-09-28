package com.lannstark.lec06;

import java.util.Arrays;
import java.util.List;

public class Lec06Main {

    public static void main(String[] args) {

        // 숫자가 들어있는 리스트를 하나씩 출력
        List<Long> numbers = Arrays.asList(1L, 2L, 3L);
        for (long number : numbers) {
            System.out.println(number);
        }

        // 1부터 3까지 출력
        for (int i = 1; i <= 3; i++) {
            System.out.println(i);
        }

        // 1부터 3까지 출력 - 내려가는 경우
        for (int i = 3; i >= 1; i--) {
            System.out.println(i);
        }

        // 2칸씩 올라가는 경우
        for (int i = 1; i <= 5; i += 2) {
            System.out.println(i);
        }

        // while 문 - 1부터 3까지 출력
        int i = 1;
        while (i <= 3) {
            System.out.println(i);
            i++;
        }

    }

}