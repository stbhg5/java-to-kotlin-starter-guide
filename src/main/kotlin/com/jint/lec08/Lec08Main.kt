package com.jint.lec08

fun main() {
    repeat("Hello World")
    repeat("Hello World", useNewLine = false)

    val array = arrayOf("A", "B", "C")
    printAll(*array)

    printAll("A", "B", "C")
}

// 일반적인 함수
public fun max(a: Int, b: Int): Int {
    /*
    if (a > b) {
        return a
    }
    return b
    */
    // if-else expression
    return if (a > b) {
        a
    } else {
        b
    }
}

// 함수가 하나의 결과값이면 block 대신 = 사용 가능
fun maxV2(a: Int, b: Int): Int =
    if (a > b) {
        a
    } else {
        b
    }

// 한 줄로 변경 가능
fun maxV3(a: Int, b: Int): Int = if (a > b) a else b

// 한 줄로 변경 가능 (= 사용하는 경우, 반환 타입 생략 가능)
fun maxV4(a: Int, b: Int) = if (a > b) a else b

// default parameter
fun repeat(
    str: String
  , num: Int = 3
  , useNewLine: Boolean = true
) {
    for (i in 1..num) {
        if (useNewLine) {
            println(str)
        } else {
            print(str)
        }
    }
}

// 같은 타입의 여러 파라미터 받기 (가변인자)
fun printAll(vararg strings: String) {
    for (str in strings) {
        println(str)
    }
}