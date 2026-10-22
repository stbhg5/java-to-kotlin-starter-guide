package com.jint.lec18

fun main() {
    val fruits = listOf(
        Fruit(1L, "사과", 1_000, 1_500)
      , Fruit(2L, "사과", 1_200, 1_500)
      , Fruit(3L, "사과", 1_200, 1_500)
      , Fruit(4L, "사과", 1_500, 1_500)
      , Fruit(5L, "바나나", 3_000, 3_200)
      , Fruit(6L, "바나나", 3_200, 3_200)
      , Fruit(7L, "바나나", 2_500, 3_200)
      , Fruit(8L, "수박", 10_000, 10_000)
    )

    // filter
    val apples = fruits.filter { fruit -> fruit.name == "사과" }

    // filterIndexed
    val apples2 = fruits.filterIndexed { i, fruit ->
        println(i)
        fruit.name == "사과"
    }

    // map
    val applePrices = fruits.filter { fruit -> fruit.name == "사과" }
                            .map { fruit -> fruit.currentPrice }

    // mapIndexed
    val applePrices2 = fruits.filter { fruit -> fruit.name == "사과" }
                             .mapIndexed { i, fruit ->
                                 println(i)
                                 fruit.currentPrice
                             }

    // mapNotNull
    val values = fruits.filter { fruit -> fruit.name == "사과" }
                       .mapNotNull { fruit -> fruit.nullOrValue() }

    // all
    val isAllApple = fruits.all { fruit -> fruit.name == "사과" }

    // none
    val isNoApple = fruits.none { fruit -> fruit.name == "사과" }

    // any
    val isAnyApple = fruits.any { fruit -> fruit.factoryPrice >= 10_000 }

    // count
    val fruitCount = fruits.count()

    // sortedBy
    val fruitSortedBy = fruits.sortedBy { fruit -> fruit.currentPrice }

    // sortedByDescending
    val fruitSortedByDescending = fruits.sortedByDescending { fruit -> fruit.currentPrice }

    // distinctBy
    val distinctFruitNames = fruits.distinctBy { fruit -> fruit.name }
                                   .map { fruit -> fruit.name }

    // first
    fruits.first()

    // firstOrNull
    fruits.firstOrNull()

    // last
    fruits.last()

    // lastOrNull
    fruits.lastOrNull()

    // groupBy
    val map: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name } // name 기준으로 그룹핑

    // associateBy
    val map2: Map<Long, Fruit> = fruits.associateBy { fruit -> fruit.id }

    // groupBy - key 와 value 동시에 처리
    val map3: Map<String, List<Long>> = fruits.groupBy({ fruit -> fruit.name }, { fruit -> fruit.factoryPrice })

    // associateBy - key 와 value 동시에 처리
    val map4: Map<Long, Long> = fruits.associateBy({ fruit -> fruit.id }, { fruit -> fruit.factoryPrice })

    // groupBy + filter
    val map5: Map<String, List<Fruit>> = fruits.groupBy { fruit -> fruit.name }
                                               .filter { (key, value) -> key == "사과" }

    // 중첩된 컬렉션
    val fruitsInList: List<List<Fruit>> = listOf(
        listOf(
            Fruit(1L, "사과", 1_000, 1_500)
            , Fruit(2L, "사과", 1_200, 1_500)
            , Fruit(3L, "사과", 1_200, 1_500)
            , Fruit(4L, "사과", 1_500, 1_500)
        )
        , listOf(
            Fruit(5L, "바나나", 3_000, 3_200)
            , Fruit(6L, "바나나", 3_200, 3_200)
            , Fruit(7L, "바나나", 2_500, 3_200)
        )
        , listOf(
            Fruit(8L, "수박", 10_000, 10_000)
        )
    )

    // 리스트 안에 리스트 필터링
    val samePriceFruits = fruitsInList.flatMap { list ->
        list.filter { fruit ->
            fruit.factoryPrice == fruit.currentPrice
        }
    }

    // 리스트 안에 리스트 필터링 리팩토링
    val samePriceFruits2 = fruitsInList.flatMap { list -> list.samePriceFilter }

}

val List<Fruit>.samePriceFilter: List<Fruit> // 확장 프로퍼티
    get() = this.filter(Fruit::isSamePrice) // 매개변수 람다 함수에 메서드 참조 문법 사용

data class Fruit(
    val id: Long
  , val name: String
  , val factoryPrice: Long
  , val currentPrice: Long
) {

    val isSamePrice: Boolean
        get() = factoryPrice == currentPrice

    fun nullOrValue(): Int? {
        return null
    }

}

// filterFruits 함수
private fun filterFruits(fruits: List<Fruit>, filter: (Fruit) -> Boolean): List<Fruit> {
    return fruits.filter(filter)
}