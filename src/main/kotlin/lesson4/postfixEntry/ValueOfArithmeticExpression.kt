package lesson4.postfixEntry

import java.util.Stack

fun main() {
    val expression = readln().trim()

    val stackOperators = Stack<Char>()
    val ans = mutableListOf<String>()

    val operations = mutableMapOf<Char, Int>().apply {
        this['-'] = 1
        this['+'] = 1
        this['*'] = 2
    }

    var lastNumber = false

    var r = 0
    var l = -1

    while (r < expression.length) {

        if (expression[r].isDigit()) {

            if (lastNumber) {
                println("WRONG")
                return
            }

            l = r
            while (r < expression.length && expression[r].isDigit()) {
                r++
            }

            ans.add(expression.substring(l, r))
            l = -1

            lastNumber = true

        } else if (expression[r] in operations) {

            if (stackOperators.isNotEmpty()) {

                while (stackOperators.size > 0 && operations[stackOperators.peek()]!! >= operations[expression[r]]!!) {
                    ans.add(stackOperators.pop().toString())
                }

                stackOperators.push(expression[r])

            } else {
                stackOperators.push(expression[r])
            }

            r++
            lastNumber = false
        }
    }
}