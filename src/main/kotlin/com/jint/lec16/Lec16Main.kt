package com.jint.lec16

import com.lannstark.lec16.Person

fun main() {
    // 확장함수 vs 멤버함수
    val person = Person("A", "B", 100)
    person.nextYearAge() // 멤버 함수 호출

    // 확장함수가 오버라이드 된다면?
    val train: Train = Train()
    train.isExpensive() // Train 의 확장함수

    val srt1: Train = Srt()
    srt1.isExpensive() // Train 의 확장함수

    val srt2: Srt = Srt()
    srt2.isExpensive() // Srt 의 확장함수

    // infix 함수
    3.add(4)
    3.add2(4)
    3 add2 4

    // inline 함수
    3.add3(4) // 함수 호출X, 바이트 코드를 보면 함수 로직이 들어감
}

// 멤버함수와 확장함수의 시그니처가 같다면?
fun Person.nextYearAge(): Int {
    println("확장 함수")
    return this.age + 1
}

// 확장함수가 오버라이드 된다면?
open class Train(
    val name: String = "새마을기차"
  , val price: Int = 5_000
)

fun Train.isExpensive(): Boolean {
    println("Train 의 확장함수")
    return this.price >= 10000
}

class Srt : Train("SRT", 40_000)

fun Srt.isExpensive(): Boolean {
    println("Srt 의 확장함수")
    return this.price >= 10000
}

// infix 함수
fun Int.add(other: Int): Int {
    return this + other
}

infix fun Int.add2(other: Int): Int {
    return this + other
}

// inline 함수
inline fun Int.add3(other: Int): Int {
    return this + other
}

// 지역함수
fun createPerson(firstName: String, lastName: String): Person {
    fun validateName(name: String, fieldName: String) {
        if (name.isEmpty()) {
            throw IllegalArgumentException("${fieldName} 은 비어있을 수 없습니다! 현재 값 : $name")
        }
    }
    validateName(firstName, "firstName")
    validateName(lastName, "lastName")

    return Person(firstName, lastName, 1)
}