package lesson4.stackOfRecords

import java.util.Stack

fun main() {
    val n = readln().trim().toInt()
    val prices = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val stack = Stack<Pair<Int, Int>>()
    val relocations = IntArray(n) { -1 }

    for (city in 0..<n) {

        while (stack.isNotEmpty() && prices[city] < stack.peek().second) {
            val (index, cost) = stack.pop()
            relocations[index] = city
        }
        stack.push(city to prices[city])
    }

    relocations.joinToString(" ").also(::println)
}