package lesson4.correctParenthesisSequence

import java.util.Stack

fun main() {
    val n = readln().trim().toInt()
    val parenthesis = readln().trim().toList()
    val string = readln().trim()

    val stack = Stack<Char>()
    val result = mutableListOf<Char>()

    val closingParenthesis = mutableMapOf(']' to '[', ')' to '(')

    for (char in string) {
        when (char) {
            '(', '[' -> {
                stack.push(char)
            }

            ')', ']' -> {
                if (stack.isNotEmpty())
                    stack.pop()
            }
        }
    }

    var remain = n - string.length

    for (i in 0..< remain) {
        for (ch in parenthesis) {

            if (ch in closingParenthesis && stack.isNotEmpty() && stack.peek() == closingParenthesis[ch]) {
                result.add(ch)
                stack.pop()
                break

            } else if (ch !in closingParenthesis && remain - i > stack.size) {
                result.add(ch)
                stack.push(ch)
                break
            }
        }
    }

    println(string + result.joinToString(""))
}