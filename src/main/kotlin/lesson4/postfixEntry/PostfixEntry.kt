package lesson4.postfixEntry

import java.util.Stack

fun main() {
    val string = readln().trim().split(Regex("\\s+"))

    val stack = Stack<Int>()

    for (element in string) {
        when (element) {

            "+" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a + b)
            }

            "-" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a - b)
            }

            "*" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a * b)
            }

            else -> {
                stack.push(element.toInt())
            }
        }
    }

    stack.peek().also(::println)
}