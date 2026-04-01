package lesson4.functionLaunchMechanism

import java.util.Stack


/*

Задача: Сортировка вагонов lite - определить можно ли отсортировать вагоны с помощью стека

Сложность = O(N)
Ограничения: 1 <= N <= 100

Время = 130ms
Память = 21.27MB

 */


fun main() {
    val n = readln().trim().toInt()
    val wagons = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    var counterSortedWagons = 0
    var counterTakeWagons = 0

    val stack = Stack<Int>()

    while (counterTakeWagons < n) {

        if (wagons[counterTakeWagons] == counterSortedWagons + 1) {
            counterTakeWagons++
            counterSortedWagons++

        } else {
            while (!stack.empty() && counterSortedWagons + 1 == stack.peek()) {
                stack.pop()
                counterSortedWagons++
            }

            if (wagons[counterTakeWagons] == counterSortedWagons + 1) {
                counterTakeWagons++
                counterSortedWagons++
            } else {
                stack.push(wagons[counterTakeWagons])
                counterTakeWagons++
            }
        }
    }

    if (stack.empty() && counterSortedWagons == n) {
        println("YES")
        return
    }

    while (!stack.empty()) {
        if (counterSortedWagons + 1 == stack.peek()) {
            stack.pop()
            counterSortedWagons++
        } else {
            println("NO")
            return
        }
    }

    if (counterSortedWagons == n) {
        println("YES")
    } else {
        println("NO")
    }
}