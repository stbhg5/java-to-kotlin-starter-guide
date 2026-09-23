package com.jint.lec04

import com.lannstark.lec04.JavaMoney

fun main() {

    // 비교 연산자 - compareTo
    val money1 = JavaMoney(2_000L)
    val money2 = JavaMoney(1_000L)

    if (money1 > money2) {
        println("Money1이 Money2보다 금액이 큽니다")
    }

    // 동일성, 동등성
    val money3 = JavaMoney(1_000L)
    val money4 = money3
    val money5 = JavaMoney(1_000L)

    println(money3 === money4) // true
    println(money3 === money5) // false
    println(money3 == money5) // true

    // Lazy 연산
    if (fun1() || fun2()) { // true
    // if (fun2() && fun1()) { // false
        println("본문")
    }

    // 연산자 오버로딩
    val money6 = Money(1_000L)
    val money7 = Money(2_000L)

    println(money6 + money7) // Money(amount=3000)

}

fun fun1(): Boolean {
    println("fun 1")
    return true
}

fun fun2(): Boolean {
    println("fun 2")
    return false
}