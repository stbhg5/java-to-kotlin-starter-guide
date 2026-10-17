package com.jint.lec14

fun main() {
    val dto1 = PersonDto("송진성", 10)
    val dto2 = PersonDto("송진성", 10)

    println(dto1 == dto2)
    println(dto1.equals(dto2))
    println(dto1)
}

data class PersonDto(
    val name: String
  , val age: Int
)