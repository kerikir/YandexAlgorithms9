package lesson4.stackOfRecords

import java.util.Stack
import kotlin.math.max

fun main() {
    val heights = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val stack = Stack<Pair<Int, Int>>()

    val recordsStraight = IntArray(heights.size)
    val recordsReverse = IntArray(heights.size)

    for (i in heights.indices) {

        while (stack.isNotEmpty() && heights[i] < stack.peek().second) {
            val (index, height) = stack.pop()
            recordsStraight[index] = i
        }
        stack.push(i to heights[i])
    }

    while (stack.isNotEmpty()) {
        val (index, height) = stack.pop()
        recordsStraight[index] = heights.size
    }

    for (i in heights.indices.reversed()) {

        while (stack.isNotEmpty() && heights[i] < stack.peek().second) {
            val (index, height) = stack.pop()
            recordsReverse[index] = i
        }
        stack.push(i to heights[i])
    }

    while (stack.isNotEmpty()) {
        val (index, height) = stack.pop()
        recordsReverse[index] = -1
    }

    var maxArea = 0L
    for ((index, height) in heights.withIndex()) {
        maxArea = max(maxArea, height * (recordsStraight[index] - recordsReverse[index] - 1).toLong())
    }
    println(maxArea)
}