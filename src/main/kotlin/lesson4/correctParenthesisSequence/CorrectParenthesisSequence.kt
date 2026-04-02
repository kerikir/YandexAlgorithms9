package lesson4.correctParenthesisSequence

import java.util.Stack

fun main() {
    val string = readln().trim()

    val stack = Stack<Char>()

    for (parenthesis in string) {
        when (parenthesis) {

            '(', '[', '{' -> {
                stack.push(parenthesis)
            }

            ')' -> {
                if (stack.isNotEmpty() && stack.peek() == '(') {
                    stack.pop()
                } else {
                    println("no")
                    return
                }
            }

            ']' -> {
                if (stack.isNotEmpty() && stack.peek() == '[') {
                    stack.pop()
                } else {
                    println("no")
                    return
                }
            }

            '}' -> {
                if (stack.isNotEmpty() && stack.peek() == '{') {
                    stack.pop()
                } else {
                    println("no")
                    return
                }
            }
        }
    }

    if (stack.empty()) {
        println("yes")
    } else {
        println("no")
    }
}