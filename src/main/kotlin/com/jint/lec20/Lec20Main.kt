package com.jint.lec20

fun main() {
    // scope function 의 분류
    val person = Person("송진성", 10)

    // value1 : age
    val value1 = person.let {
        it.age
    }

    // value2 : age
    val value2 = person.run {
        this.age
    }

    // value3 : person
    val value3 = person.also {
        it.age
    }

    // value4 : person
    val value4 = person.apply {
        this.age
    }

    // let
    // 하나 이상의 함수를 call chain 결과로 호출할 때,
    val strings = listOf("APPLE", "CAR")
    strings.map { it.length }
           .filter { it > 3 }
           .let(::println)
           // .let { lengths -> println(lengths) } // List<Int> 에 대한 복수형 lengths

    // non-null 값에 대해서만 code block 을 실행시킬 때, (제일 많이 사용됨)
    val str = "test"
    val length = str?.let {
        println(it.uppercase())
        it.length
    }

    // 일회성으로 제한된 영역에 지역 변수를 만들 때, (잘 사용하지 않음)
    val numbers = listOf("one", "two", "three", "four")
    val modifiedFirstItem = numbers.first()
        .let { firstItem ->
            if (firstItem.length >= 5) firstItem else "!${firstItem}!"
        }.uppercase()
    println(modifiedFirstItem)

    // 객체 초기화와 반환 값의 계산을 동시에 해야 할 때,
    // 이 때 객체를 만들어 DB에 바로 저장하고, 그 인스턴스를 활용할 때,
    // DB 저장된 person 반환됨
    val personRepository = PersonRepository()
    val person2 = Person("송진성", 10).run(personRepository::save)
    val person3 = Person("송진성", 10).run {
        hobby = "운동"
        personRepository.save(this)
    }

    // also
    // 객체를 수정하는 로직이 call chain 중간에 필요할 때,
    mutableListOf("one", "two", "three").also { println("four 추가 이전 지금 값: ${it}") }
                                        .add("four")

    // 위와 동일한 코드 - 익숙하니 이 방법을 더 많이 사용
    val numbers2 = mutableListOf("one", "two", "three")
    println("four 추가 이전 지금 값: ${numbers2}")
    numbers2.add("four")

    // apply
    // 객체 설정을 할 때 객체를 수정하는 로직이 call chain 중간에 필요할 때,
    // (Test Fixture(고정물) 를 만들 때)
    fun createPerson(
        name: String
        , age: Int
        , hobby: String
    ): Person {
        return Person(
            name = name
            , age = age
        ).apply {
            this.hobby = hobby
        }
    }

    // 아래 코드도 가능은 하다. (잘 쓰진 않지만 이론상 가능)
    val person4 = Person("송진성", 10)
    person.apply { this.growOld() }
          .let { println(it) }

    // with
    // 특정 객체를 다른 객체로 변환해야 하는데, 모듈 간의 의존성에 의해 정적 팩토리 혹은 toClass 함수(또는 부생성자)를 만들기 어려울 때,
    // this 를 생략할 수 있어 필드가 많아도 코드가 간결해진다.
    return with(person) {
        PersonDto(
            name = name
          , age = age
        )
    }
}

// scope function
fun printPerson(person: Person?) {
    person?.let {
        println(it.name)
        println(it.age)
    }
}

data class Person(
    val name: String
  , val age: Int
) {

    var hobby = "독서"

    fun growOld() {
        age + 1
    }

}

class PersonRepository {

    fun save(person: Person) {}

}

class PersonDto(
    val name: String
  , val age: Int
)