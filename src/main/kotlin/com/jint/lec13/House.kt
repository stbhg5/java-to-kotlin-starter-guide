package com.jint.lec13

fun main() {
    House("제주도")
    House.LivingRoom(1.1)
    House2("제주도").address
}

class House(
    private var address: String
  , private var livingRoom: LivingRoom = LivingRoom(10.0)
) {

    class LivingRoom(
        private var area: Double
    )

}

class House2(
    var address: String
) {

    var livingRoom = this.LivingRoom2(10.0)

    inner class LivingRoom2(
        private var area: Double
    ) {

        val address: String
            get() = this@House2.address

    }

}