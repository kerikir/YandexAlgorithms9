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

    var remain = n - string.length

    while (remain > 0) {

        if (remain == stack.size) {

            if (stack.peek() == '(') {
                result.add(')')
            } else {
                result.add(']')
            }

            stack.pop()
            remain--

        } else if (stack.isNotEmpty() &&
            stack.peek() == '(' && parenthesis.indexOf(')') < bestParenthesisIndex
        ) {
            stack.pop()
            result.add(')')
            remain--

        } else if (stack.isNotEmpty() &&
            stack.peek() == '[' && parenthesis.indexOf(']') < bestParenthesisIndex
        ) {
            stack.pop()
            result.add(']')
            remain--

        } else {
            result.add(bestParenthesis)
            stack.push(bestParenthesis)
            remain--
        }
    }

    println(result.joinToString(""))
}