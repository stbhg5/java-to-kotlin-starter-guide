package com.jint.lec03

import com.lannstark.lec03.Person

fun main() {
    // to변환타입() - 변수가 nullable 이라면 적절한 처리 필요
    val kNumber1: Int? = 4
    val kNumber2: Long = kNumber1?.toLong() ?: 0L

    // ${변수}
    val person = Person("송진성", 100)
    val log = "사람의 이름은 ${person.name}이고 나이는 ${person.age}세 입니다"

    // $변수
    val name = "송진성"
    val age = 100
    val log2 = "사람의 이름: $name 나이: $age"

    val log3 = "사람의 이름: ${name} 나이: ${age}"

    println(log3)

    // 여러 줄에 걸친 문자열 작성 : """ 사용
    val withoutIndent = """
    ABC
        123
            456
    ${name}
    """.trimIndent()

    println(withoutIndent)

    // 문자열의 특정 문자 가져오기
    val str = "ABCDE"
    val ch = str[1]

    println(ch)
}

fun printAgeIfPerson(obj: Any) {
    if (obj is Person) {
        val person = obj as Person
        println(person.age)

        println(obj.age) // 스마트 캐스트
    }
}

fun printAgeIfPerson2(obj: Any?) {
    if (obj !is Person) {
        val person = obj as? Person // nullable person -> person: Person?
        println(person?.age)
    }
}