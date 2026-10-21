package com.jint.lec17

import com.lannstark.lec17.Fruit

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_200),
        Fruit("사과", 1_200),
        Fruit("사과", 1_500),
        Fruit("바나나", 3_000),
        Fruit("바나나", 3_200),
        Fruit("바나나", 2_500),
        Fruit("수박", 10_000)
    )

    // 람다를 직접 호출하는 방법 1
    isApple(Fruit("사과", 1000))
    // isApple(fruits[0])

    // 람다를 직접 호출하는 방법 2
    isApple.invoke(Fruit("사과", 1000))
    // isApple.invoke(fruits[0])

    // filterFruits 함수 호출
    // 함수를 변수에 넣지 않고 바로 파라미터로 넣기도 가능
    val isApple: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }
    filterFruits(fruits, isApple)

    // 마지막 파라미터가 함수인 경우, 소괄호 밖에서 람다 사용 가능
    // 람다 작성시, 파라미터가 1개인 경우 람다의 파라미터를 it 으로 직접 참조할 수 있다!
    filterFruits(fruits) { it.name == "사과" }

    // 람다를 여러줄 작성할 수 있고, 마지막 줄의 expression 결과가 람다의 반환값이다!
    filterFruits(fruits) { fruit ->
        println("사과만 받는다..!!")
        fruit.name == "사과"
    }

    // 람다가 실행되는 시점에 쓰고 있는 변수들을 모두 포획한 데이터 구조를 Closure 라고 부른다.
    var targetFruitName = "바나나"
    targetFruitName = "수박"
    filterFruits(fruits) { it.name == targetFruitName }
}

// 람다를 만드는 방법 1 (익명함수)
val isApple = fun(fruit: Fruit): Boolean {
    return fruit.name == "사과"
}

// 람다를 만드는 방법 2 (더 많이 사용됨)
val isApple2 = { fruit: Fruit -> fruit.name == "사과" }

// 람다를 만드는 방법 3 - 타입 명시
val isApple3: (Fruit) -> Boolean = fun(fruit: Fruit): Boolean {
    return fruit.name == "사과"
}

// 람다를 만드는 방법 4 - 타입 명시
val isApple4: (Fruit) -> Boolean = { fruit: Fruit -> fruit.name == "사과" }

// filterFruits 함수
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    // JDK+8 처럼 선언식으로 변경 가능
    val results = mutableListOf<Fruit>()
    for (fruit in fruits) {
        if (filter.invoke(fruit)) {
        // if (filter(fruit)) {
            results.add(fruit)
        }
    }
    return results
}