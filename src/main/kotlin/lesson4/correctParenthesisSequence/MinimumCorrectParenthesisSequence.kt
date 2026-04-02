package lesson4.correctParenthesisSequence

import java.util.Stack

fun main() {
    val n = readln().trim().toInt()
    val parenthesis = readln().trim()
    val string = readln().trim()

    if (n == string.length) {
        println(string)
        return
    }

    val bestParenthesis = parenthesis.first { it == '(' || it == '[' }
    val bestParenthesisIndex = parenthesis.indexOf(bestParenthesis)

    val stack = Stack<Char>()
    val result = mutableListOf<Char>()

    for (char in string) {

        result.add(char)

        when (char) {
            '(', '[' -> {
                stack.push(char)
            }

            ')', ']' -> {
                stack.pop()
            }
        }
    }

    if (n - string.length > stack.size) {
        val m = (n - string.length - stack.size) / 2

        repeat(m) {

            if (stack.isNotEmpty() &&
                ((stack.peek() == '(' && parenthesis.indexOf(')') < bestParenthesisIndex) ||
                 (stack.peek() == '[' && parenthesis.indexOf(']') < bestParenthesisIndex))
            ) {
                result.add(stack.pop())
            } else {
                result.add(bestParenthesis)
                stack.push(bestParenthesis)
            }
        }
    }

    repeat(stack.size) {

        if (stack.peek() == '(') {
            result.add(')')
        } else {
            result.add(']')
        }

        stack.pop()
    }

    println(result.joinToString(""))
}