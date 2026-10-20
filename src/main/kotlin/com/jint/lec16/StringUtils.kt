package com.jint.lec16

fun main() {
    // 확장함수
    val str: String = "ABC"
    println(str.lastChar())
}

// 확장함수
fun String.lastChar(): Char {
    return this[this.length - 1]
}

// 확장함수 라는 개념은 확장 프로퍼티와도 연결됨 (확장함수 + custom getter)
val String.lastChar: Char
    get() = this[this.length - 1]