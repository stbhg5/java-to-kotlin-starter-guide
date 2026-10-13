package com.jint.lec09

import com.lannstark.lec09.JavaPerson

fun main() {
    // 클래스.필드를 통해 getter 와 setter 를 바로 호출
    val person = Person("송진성", 100)
    println(person.name)
    person.age = 10
    println(person.age)

    // Java 클래스에 대해서도 클래스.필드로 getter 와 setter 를 사용
    val javaPerson = JavaPerson("송진성", 100)
    println(javaPerson.name)
    javaPerson.age = 10
    println(javaPerson.age)

    // 최초로 태어나는 아기는 무조건 1살이니, 생성자를 하나 더 생성
    val person2 = Person("송진성")

    // 주생성자에 파라미터가 없는 경우
    Student()

    // 본문은 역순으로 실행
    Person()
}

class Person(
    val name: String = "송진성"
    // name: String = "송진성"
  , var age: Int = 1
) {

    /*
    val name: String = name
        get() = field.uppercase()
    */

    /*
    fun getUppercaseName(): String {
        return this.name.uppercase()
    }
    */
    // fun getUppercaseName(): String = this.name.uppercase()

    val uppercaseName: String
        get() = this.name.uppercase()

    /*
    var name: String = name
        set(value) {
            field = value.uppercase()
        }
    */

    init {
        if (age <= 0) {
            throw IllegalArgumentException("나이는 ${age}일 수 없습니다")
        }
        println("초기화 블록")
    }

    constructor(name: String) : this(name, 1) {
        println("부생성자 1")
    }

    constructor() : this("홍길동") {
        println("부생성자 2")
    }

    // 성인인지 확인하는 기능 추가
    /*
    fun isAdult(): Boolean {
        return this.age >= 20
    }
    */

    // 함수 대신 프로퍼티로도 만들 수 있다.
    val isAdult: Boolean
        get() = this.age >= age
    // expression
    val isAdult2: Boolean
        get() {
            return this.age >= 20
        }

}

class Student