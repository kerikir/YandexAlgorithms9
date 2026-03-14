package lesson1.testAutomation

import kotlin.math.abs


fun main() {
    val input = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val shops = mutableListOf<Int>()
    val houses = mutableListOf<Int>()

    for ((index, element) in input.withIndex()) {
        when(element) {
            1 -> houses.add(index)
            2 -> shops.add(index)
        }
    }

    var maxDistance = Int.MIN_VALUE
    for (house in houses) {
        var minDistance = Int.MAX_VALUE

        for (shop in shops) {
            val distance = abs(house - shop)
            if (minDistance > distance) minDistance = distance
        }

        if (maxDistance < minDistance) {
            maxDistance = minDistance
        }
    }

    println(maxDistance)
}