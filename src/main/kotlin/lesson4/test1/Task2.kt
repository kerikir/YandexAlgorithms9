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
                buffer = stacks[page].toList().takeLast(k)
            }

            "Paste" -> {
                for (element in buffer) {
                    stacks[page].addLast(element)
                }
            }

            "Backspace" ->{
                if (stacks[page].isNotEmpty()) {
                    stacks[page].removeLast()
                }
            }

            else -> {
                stacks[page].addLast(command)
            }
        }
    }

    if (stacks[page].isNotEmpty()) {
        println(stacks[page].takeLast(k).joinToString(""))
    } else {
        println("Empty")
    }
}