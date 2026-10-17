package com.jint.lec14

fun main() {
    // Enum
    handleCountry(Country.KOREA)

    // Sealed Class
    handleCar(Avante())
}

private fun handleCountry(country: Country) {
    when (country) {
        Country.KOREA -> TODO()
        Country.AMERICA -> TODO()
        // else -> TODO() // 필요 없음
    }
}

private fun handleCar(car: HyundaiCar) {
    when (car) {
        is Avante -> TODO()
        is Sonata -> TODO()
        is Grandeur -> TODO()
    }
}