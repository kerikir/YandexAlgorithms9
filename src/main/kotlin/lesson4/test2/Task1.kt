package lesson4.test2

import java.util.*


/*

Задача: Скобочный сдвиг - определить является ли последовательность циклическим сдвигом
                          правильной скобочной последовательности

Сложность = O(S^2)
Ограничения: 1 <= S <= 1_000

Время = 176ms
Память = 22.31MB

 */


fun main() {
    val string = readln().trim()

    if (string.isBlank()) {
        println("YES")
        return
    }

    var result = false
    for (shift in string.indices) {
        if (isCorrectParenthesisSequence(string, shift)) {
            result = true
        }
    }

    if (result) {
        println("YES")
    } else {
        println("NO")
    }
}


fun isCorrectParenthesisSequence(string: String, k: Int): Boolean {
    val stack = Stack<Char>()

    for (index in string.indices) {

        when (val parenthesis = string[(index + k) % string.length]) {

            '(', '[', '{' -> {
                stack.push(parenthesis)
            }

            ')' -> {
                if (stack.isNotEmpty() && stack.peek() == '(') {
                    stack.pop()
                } else {
                    return false
                }
            }

            ']' -> {
                if (stack.isNotEmpty() && stack.peek() == '[') {
                    stack.pop()
                } else {
                    return false
                }
            }

            '}' -> {
                if (stack.isNotEmpty() && stack.peek() == '{') {
                    stack.pop()
                } else {
                    return false
                }
            }
        }
    }

    return stack.empty()
}