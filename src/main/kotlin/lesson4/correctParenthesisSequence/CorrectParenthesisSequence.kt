package lesson4.correctParenthesisSequence

import java.util.Stack


/*

Задача: Правильная скобочная последовательность - определить является ли последовательность ПСП

Сложность = O(N)
Ограничения: 0 <= N <= 100_000

Время = 206ms
Память = 21.14MB

 */


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