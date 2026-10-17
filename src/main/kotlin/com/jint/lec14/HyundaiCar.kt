package com.jint.lec14

sealed class HyundaiCar(
    private val name: String
  , private val price: Long
)

class Avante : HyundaiCar("아반떼", 1_000L)

class Sonata : HyundaiCar("소나타", 2_000L)

class Grandeur : HyundaiCar("그렌저", 3_000L)