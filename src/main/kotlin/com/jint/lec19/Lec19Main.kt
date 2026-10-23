package com.jint.lec19

// import as
import com.jint.lec19.a.printHelloWorld as printHelloWorldA
import com.jint.lec19.b.printHelloWorld as printHelloWorldB

fun main() {
    // 다른 패키지의 같은 이름 함수를 동시에 가져옴
    printHelloWorldA()
    printHelloWorldB()

    // 구조분해
    val person = Person("송진성", 20)
    val (name, age) = person
    println("이름 : ${name}, 나이 : ${age}")

    // 구조분해 원리 : data class 는 componentN 이란 함수도 자동으로 만들어준다!
    val person2 = Person("송진성", 20)
    val name2 = person2.component1()
    val age2 = person2.component2()

    // data 클래스가 아닌데 구조분해
    val person3 = Person2("송진성", 20)
    val (name3, age3) = person

    // 구조분해
    val map = mapOf(1 to "A", 2 to "B")
    for ((key, value) in map.entries) {

    }

    // forEach + break
    val numbers = listOf(1, 2, 3, 4, 5)
    run {
        numbers.forEach { number ->
            if (number == 3) {
                return@run
            }
            println(number)
        }
    }

    // forEach + continue
    numbers.forEach {
        println(it)
        if (it == 3) {
            return@forEach
        }
    }

    // Label
    loop@ for (i in 1..100) {
        for (j in 1..100) {
            if (j == 2) {
                break@loop // 가장 가까운 반복문 멈추지 않고 loop@ 가 붙은 첫 번째 for 문 멈춤
            }
            print("${i} ${j}")
        }
    }

    // TakeIf 와 TakeUnless
    val number: Int = 1
    fun getNumberOrNull(): Int? {
        return if (number <= 0) {
            null
        } else {
            number
        }
    }

    // takeIf
    fun getNumberOrNullV2(): Int? {
        return number.takeIf { it > 0 }
    }

    // takeUnless
    fun getNumberOrNullV3(): Int? {
        return number.takeUnless { it <= 0 }
    }
}

// typealias
typealias FruitFilter = (Fruit) -> Boolean

fun filterFruits(fruits: List<Fruit>, filter: FruitFilter) {

}

class Fruit()

data class UltraSuperGuardianTribe(
    val name: String
)

typealias USGTMap = Map<String, UltraSuperGuardianTribe>

// 구조분해와 componentN 함수
data class Person(
    val name: String
  , val age: Int
)

// data 클래스가 아닌데 구조분해를 하고 싶다면, componentN 함수를 직접 구현
class Person2(
    val name: String
  , val age: Int
) {

    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): Int {
        return this.age
    }

}