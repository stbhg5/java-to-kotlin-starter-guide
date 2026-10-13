package com.jint.lec10

interface Swimable {

    val swimAbility: Int // 인터페이스 내부 default 메서드에서 사용 가능한데, 구현 클래스에서 구현할 것이라 믿기 때문
        get() = 1 // getter 로 기본값 설정 가능, 구현 클래스에서 추가로 구현하여 값 가져와 조작할 수 있음

    fun act() {
        println(swimAbility)
        println("어푸 어푸")
    }

}