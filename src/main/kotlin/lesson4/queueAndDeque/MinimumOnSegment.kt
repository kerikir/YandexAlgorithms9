package lesson4.queueAndDeque

import java.util.ArrayDeque

fun main() {
    val (n, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val array = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val deque = ArrayDeque<Int>()
    val result = mutableListOf<Int>()

    for (i in 0..<k) {
        while (deque.isNotEmpty() && deque.peekLast() > array[i]) {
            deque.pollLast()
        }
        deque.offerLast(array[i])
    }
    result.add(deque.peekFirst())

    for (i in k..<n) {
        if (deque.isNotEmpty() && deque.peekFirst() == array[i - k]) {
            deque.pollFirst()
        }

        while (deque.isNotEmpty() && deque.peekLast() > array[i]) {
            deque.pollLast()
        }
        deque.offerLast(array[i])

        result.add(deque.peekFirst())
    }

    result.joinToString("\n").also(::println)
}