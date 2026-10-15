package com.jint.lec12

fun main() {
    Person.newBaby("송진성")
}

class Person private constructor(
    private val name: String
  , private val age: Int
) {

    companion object Factory : Log {
        // 선언된 초기값을 보고 타입 추론
        // private val MIN_AGE = 1 // 런타임 시 변수 할당
        private const val MIN_AGE = 1 // 컴파일 시 변수 할당

        @JvmStatic
        fun newBaby(name: String): Person {
            return Person(name, MIN_AGE)
        }

        override fun log() {
            println("LOG")
        }
    }

}