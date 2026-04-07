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

    var openParenthesis = 0

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

                while (stackOperators.size > 0 && stackOperators.peek() != '('
                    && operations[stackOperators.peek()]!! >= operations[expression[r]]!!) {

                    ans.add(stackOperators.pop().toString())
                }

                stackOperators.push(expression[r])

            } else {
                stackOperators.push(expression[r])
            }

            if (!lastNumber) {
                println("WRONG")
                return
            }

            r++
            lastNumber = false

        } else if (expression[r] == '(') {
            stackOperators.push('(')
            r++
            openParenthesis++

        } else if (expression[r] == ')') {

            while (stackOperators.size > 0 && stackOperators.peek() != '(') {
                ans.add(stackOperators.pop().toString())
            }

            if (stackOperators.isNotEmpty() && stackOperators.peek() == '(') {
                stackOperators.pop()
            }

            r++

            if (openParenthesis > 0) {
                openParenthesis--
            } else {
                println("WRONG")
                return
            }

        } else if (expression[r] == ' ') {
            r++

        } else {
            println("WRONG")
            return
        }
    }

    while (stackOperators.size > 0) {
        ans.add(stackOperators.pop().toString())
    }




}


fun convertInfixToPostfix(list: List<String>): List<String> {

}


fun calculatePostfix(list: List<String>): Int {
    val stack = Stack<Int>()

    for (element in list) {
        when(element) {

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
}