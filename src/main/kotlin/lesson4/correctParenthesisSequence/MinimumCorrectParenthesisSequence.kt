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
       if (char in closingParenthesis) {
           stack.pop()
       } else {
           stack.push(char)
       }
    }

    var remain = n - string.length

    while (remain > 0) {

        for (ch in parenthesis) {

            if (ch in closingParenthesis && stack.isNotEmpty() && stack.peek() == closingParenthesis[ch]) {
                result.add(ch)
                stack.pop()
                break

            } else if (ch !in closingParenthesis && remain > stack.size) {
                result.add(ch)
                stack.push(ch)
                break
            }
        }

        remain--
    }

    println(string + result.joinToString(""))
}