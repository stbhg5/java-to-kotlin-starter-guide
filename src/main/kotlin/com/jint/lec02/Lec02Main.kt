package com.jint.lec02

import com.lannstark.lec02.Person

fun main() {
    // 2. Safe Call 과 Elvis 연산자
    val str: String? = "ABC"
    // str.length // 불가능
    str?.length // 가능

    val str2: String? = null
    str2?.length ?: 0

    // 3. null 아님 단언 (!!)
    startsWithA7(null) // NPE

    // 4. 플랫폼 타입
    val person = Person("코틀린 공부하는 개발자")
    // startsWithA(person.name) // @Nullable 이기 때문에 에러
}

// 1. Kotlin 에서의 null 체크
fun startsWithA1(str: String?): Boolean {
    if (str == null) {
        throw IllegalArgumentException("null이 들어왔습니다")
    }
    return str.startsWith("A")
}

fun startsWithA2(str: String?): Boolean? {
    if (str == null) {
        return null
    }
    return str.startsWith("A")
}

fun startsWithA3(str: String?): Boolean {
    if (str == null) {
        return false
    }
    return str.startsWith("A")
}


// 2. Safe Call 과 Elvis 연산자 - 적용
fun startsWithA4(str: String?): Boolean {
    return str?.startsWith("A") ?: throw IllegalArgumentException("null이 들어왔습니다")
}

fun startsWithA5(str: String?): Boolean? {
    return str?.startsWith("A")
}

fun startsWithA6(str: String?): Boolean {
    return str?.startsWith("A") ?: false
}


// 3. null 아님 단언 (!!)
fun startsWithA7(str: String?): Boolean {
    return str!!.startsWith("A")
}


// 4. 플랫폼 타입
fun startsWithA(str: String): Boolean {
    return str.startsWith("A")
}