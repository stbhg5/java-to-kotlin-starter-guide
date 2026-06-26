package com.jint.lec01

import com.lannstark.lec01.Person

fun main() {

    // 1. 변수 선언 키워드 - var 과 val 의 차이점
    var number1 = 10L
    // number1 = 5L // 가능
    // var number1: Long = 10L // 타입 명시 가능

    // var varTypeInit // 타입 명시하지 않았기 때문에 컴파일러가 타입 추론 못함
    var varTypeInit: Long // 타입 지정시 에러 사라짐
    // println(varTypeInit) // 초기화 되지 않아 에러 발생
    varTypeInit = 5L
    varTypeInit += 5L // 가능
    println(varTypeInit) // 작동함

    val number2 = 10L
    // number2 = 5L // 불가능 - 할당 불가 에러 발생

    // val valTypeInit // 타입 명시하지 않았기 때문에 컴파일러가 타입 추론 못함
    val valTypeInit: Long // 타입 지정시 에러 사라짐
    // println(valTypeInit) // 초기화 되지 않아 에러 발생
    valTypeInit = 5L
    // valTypeInit += 5L // 불가능
    println(valTypeInit) // 작동함

    // 2. Kotlin 에서의 Primitive Type
    var longNumber1: Long = 10L
    val longNumber3: Long = 1_000L // 숫자 사이 _ (언더스코어)는 컴파일러가 무시 : 가독성 향상

    // 3. Kotlin 에서의 nullable 변수
    var nullableLongNumber1: Long = 10L
    // nullableLongNumber1 = null // 에러 발생 - 코틀린은 기본적으로 모든 변수에 null 이 들어갈 수 없도록 설계
    var nullableLongNumber2: Long? = 10L
    nullableLongNumber2 = null

    // 4. Kotlin 에서의 객체 인스턴스화
    // new 붙이기 않기
    var person = Person("송진성") // 자바 Person 클래스 가져올 수 있음

}