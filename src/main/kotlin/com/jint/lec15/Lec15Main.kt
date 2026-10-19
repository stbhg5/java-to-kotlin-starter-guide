package com.jint.lec15

fun main() {
    // 배열
    var array = arrayOf(100, 200)

    // 값 넣기
    array = array.plus(300)

    // indices
    for (i in array.indices) {
        println("${i} ${array[i]}")
    }

    // withIndex
    for ((i, value) in array.withIndex()) {
        println("${i} ${value}")
    }


    // 컬렉션
    // List
    // 선언
    val numbers = listOf(100, 200) // 불변 리스트, listOf<Int>(100, 200)
    val emptyList = emptyList<Int>()
    useNumbers(emptyList())

    // 값 가져오기
    // 하나를 가져오기 - 배열처럼 대괄호 가능
    println(numbers[0]) // numbers.get(0) 도 가능

    // For Each
    for (number in numbers) {
        println(number)
    }

    // 전통적인 For문 느낌
    for ((i, number) in numbers.withIndex()) {
        println("${i} ${number}")
    }

    // 가변(Mutable) 리스트
    val mNumbers = mutableListOf(100, 200) // 기본 구현체는 ArrayList
    mNumbers.add(300)


    // Set
    // 선언
    val sNumbers = setOf(100, 200)

    // For Each
    for (sNumber in sNumbers) {
        println(sNumber)
    }

    // 전통적인 For문
    for ((i, sNumber) in sNumbers.withIndex()) {
        println("${i} ${sNumber}")
    }

    // 가변(Mutable) 집합
    val msNumbers = mutableSetOf(100, 200) // 기본 구현체는 LinkedHashSet
    msNumbers.add(300)


    // Map
    // 가변(Mutable) 맵
    val map = mutableMapOf<Int, String>() // 타입을 추론할 수 없어 타입 지정
    map[1] = "MONDAY" // map.put(1, "MONDAY") 도 가능
    map[2] = "TUESDAY"

    // 불변 맵
    mapOf(1 to "MONDAY", 2 to "TUESDAY") // 중위 호출 함수 to 는 Pair 반환

    // 값 가져오기
    for (key in map.keys) {
        println(key)
        println(map[key])
    }

    for ((key, value) in map.entries) {
        println(key)
        println(value)
    }
}

private fun useNumbers(numbers: List<Int>) {}