package com.jint.lec10

abstract class Animal(
    protected val species: String
  , protected open val legCount: Int
) {

    abstract fun move() // Unit 생략 가능

}