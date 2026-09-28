package com.jint.lec06

fun main() {

    // 숫자가 들어있는 리스트를 하나씩 출력
    val numbers = listOf(1L, 2L, 3L) // 컬렉션 생성
    for (number in numbers) { // : 대신 in 사용
        println(number)
    }

    // 1부터 3까지 출력
    for (i in 1..3) { // 1..3 : 1부터 3까지
        println(i)
    }

    // 1부터 3까지 출력 - 내려가는 경우
    for (i in 3 downTo 1) {
        println(i)
    }

    // 2칸씩 올라가는 경우
    for (i in 1..5 step 2) {
        println(i)
    }

    // while 문 - 1부터 3까지 출력
    var i = 1;
    while (i <= 3) {
        println(i)
        i++
    }

}