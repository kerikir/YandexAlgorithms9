package lesson4.postfixEntry

import java.util.Stack

fun main() {
    var expression = readln().trim()

    if (expression[0] == '-') {
        expression = "0$expression"
    }
    expression = expression.replace("(-", "(0-")

    val symbols = mutableSetOf("+", "-", "*", "(", ")")
    for (symbol in symbols) {
        expression = expression.replace(symbol, " $symbol ")
    }

    convertInfixToPostfix(
        list = expression
            .split(Regex("\\s+"))
            .filter { it.isNotBlank() }
    ).also { postfix ->

        if (postfix.size == 1) {
            println(postfix.first())
        } else {
            calculatePostfix(postfix).also(::println)
        }
    }
}


fun convertInfixToPostfix(list: List<String>): List<String> {
    val stackOperators = Stack<String>()
    val ans = mutableListOf<String>()

    val brackets = mutableSetOf("(", ")")
    val operations = mutableMapOf<String, Int>().apply {
        this["-"] = 1
        this["+"] = 1
        this["*"] = 2
    }

    var prevType = "operation"

    for (element in list) {

        if (element in operations && prevType != "number") {
            return listOf("WRONG")
        }

        if (element in operations) {

            while (stackOperators.isNotEmpty() && stackOperators.peek() in operations &&
                operations[stackOperators.peek()]!! >= operations[element]!!) {

                ans.add(stackOperators.pop())
            }
            stackOperators.push(element)
            prevType = "operation"

        } else if (element.toIntOrNull() != null) {

            if (prevType == "number") {
                return listOf("WRONG")
            }

            ans.add(element)
            prevType = "number"

        } else if (element in brackets) {

            if (element == "(") {
                if (prevType == "number") {
                    return listOf("WRONG")
                }
                stackOperators.push(element)
                prevType = "bracket"

            } else {
                while (stackOperators.isNotEmpty() && stackOperators.peek() != "(") {
                    ans.add(stackOperators.pop())
                }

                if (stackOperators.empty()) {
                    return listOf("WRONG")
                }
                stackOperators.pop()
            }

        } else {
            return listOf("WRONG")
        }
    }

    if (prevType != "number") {
        return listOf("WRONG")
    }

    while (stackOperators.isNotEmpty()) {
        if (stackOperators.peek() == "(") {
            return listOf("WRONG")
        }

        ans.add(stackOperators.pop())
    }

    return ans
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

    return stack.first()
}