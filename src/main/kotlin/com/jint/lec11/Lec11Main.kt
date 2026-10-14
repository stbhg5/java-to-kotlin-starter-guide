package com.jint.lec11

// 한 파일에 여러 개의 변수, 함수, 클래스 생성 가능
val a = 3

fun add(a: Int, b: Int): Int {
    return a + b
}

class A()

// 생성자에 접근 지시어를 붙이려면, constructor 키워드 사용해야 함
public class Bus internal constructor(
    val price: Int
)

internal open class Cat protected constructor() {}

// 프로퍼티 가시성 제어 방법 2가지
class Car(
    internal val name: String // getter 접근 지시어를 정함
  , private var owner: String // getter, setter 한 번에 접근 지시어를 정함
  , _price: Int // 단순 파라미터는 getter, setter 생성되지 않음
) {

    public var price = _price
        get() = 1
        private set // setter 에만 추가로 가시성을 부여할 수 있음

}