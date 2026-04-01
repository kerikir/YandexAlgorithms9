package lesson4.functionLaunchMechanism

import java.util.Stack


/*

Задача: Стек с защитой от ошибок - вывести протокол работы стека

Сложность = O(N)
Ограничения: нет данных

Время = 544ms
Память = 36.12MB

 */


fun main() {

    val stack = Stack<Int>()

    while (true) {
        val operation = readln().trim()

        when {
            operation.contains("push") -> {
                val (_, n) = operation.split(Regex("\\s+"))
                stack.push(n.toInt())
                println("ok")
            }

            operation.contains("pop") -> {
                if (stack.size > 0) {
                    val a = stack.pop()
                    println(a)
                } else {
                    println("error")
                }
            }

            operation.contains("back") -> {
                if (stack.size > 0) {
                    val a = stack.peek()
                    println(a)
                } else {
                    println("error")
                }
            }

            operation.contains("size") -> {
                println(stack.size)
            }

            operation.contains("clear") -> {
                stack.clear()
                println("ok")
            }

            operation.contains("exit") -> {
                println("bye")
                break
            }
        }
    }
}