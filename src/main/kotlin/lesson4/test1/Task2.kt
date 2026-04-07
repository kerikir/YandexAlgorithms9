package lesson4.test1

import java.util.Stack

fun main() {
    val (n, m, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val stacks = Array<ArrayDeque<String>>(n) {
        ArrayDeque<String>()
    }

    val commands = mutableListOf<String>().apply {
        repeat(m) {
            val command = readln().trim()
            add(command)
        }
    }

    var page = 0
    var buffer = emptyList<String>()

    for (command in commands) {
        when (command) {
            "Next" -> { page = (page + 1) % n }

            "Copy" -> {
                buffer = stacks[page].toList()
            }

            "Paste" -> {
                for (element in buffer) {
                    stacks[page].addLast(element)
                }
                while (stacks[page].size > k) {
                    stacks[page].removeFirst()
                }
            }

            "Backspace" ->{
                if (stacks[page].isNotEmpty()) {
                    stacks[page].removeLast()
                }
            }

            else -> {
                stacks[page].addLast(command)
                while (stacks[page].size > k) {
                    stacks[page].removeFirst()
                }
            }
        }
    }

    if (stacks[page].isNotEmpty()) {
        println(stacks[page].joinToString(""))
    } else {
        println("Empty")
    }
}