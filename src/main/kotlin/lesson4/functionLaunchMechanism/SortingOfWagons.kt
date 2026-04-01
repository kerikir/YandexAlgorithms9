package lesson4.functionLaunchMechanism

import java.util.Stack

fun main() {
    val wagons = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    var counterSortedWagons = 0
    var counterTakeWagons = 0

    val stack = Stack<Int>()

    while (counterTakeWagons < wagons.size) {

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

    if (stack.empty() && counterSortedWagons == wagons.size) {
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

    if (counterSortedWagons == wagons.size) {
        println("YES")
    } else {
        println("NO")
    }
}