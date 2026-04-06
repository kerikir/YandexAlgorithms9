package lesson4.stackOfRecords

import java.util.Stack

fun main() {
    val heights = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val stack = Stack<Pair<Int, Int>>()

    val histograms = LongArray(heights.size)

    for (i in heights.indices) {

        while (stack.isNotEmpty() && heights[i] < stack.peek().second) {
            val (index, height) = stack.pop()
            histograms[index] += height.toLong() * (i - index)
        }
        stack.push(i to heights[i])
    }

    while (stack.isNotEmpty()) {
        val (index, height) = stack.pop()
        histograms[index] += height.toLong() * (heights.size - index)
    }

    for (i in heights.indices.reversed()) {

        while (stack.isNotEmpty() && heights[i] < stack.peek().second) {
            val (index, height) = stack.pop()
            histograms[index] += height.toLong() * (index - i - 1)
        }
        stack.push(i to heights[i])
    }

    while (stack.isNotEmpty()) {
        val (index, height) = stack.pop()
        histograms[index] += height.toLong() * (index)
    }

    histograms.max().also(::println)
}