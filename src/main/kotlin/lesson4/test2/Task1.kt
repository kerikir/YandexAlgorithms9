package lesson4.test2

import java.util.*

fun main() {
    val string = readln().trim()

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