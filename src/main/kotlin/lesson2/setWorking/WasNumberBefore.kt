package lesson2.setWorking

/*

Задача: Встречалось ли число - определить встречалось ли число раньше в последовательности

Сложность = O(N)
Ограничения: не известно

Время = 982ms
Память = 50.1MB

 */


fun main() {
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val set = mutableSetOf<Int>()
    for (number in numbers) {

        if (set.contains(number)) {
            println("YES")
        } else {
            println("NO")
        }

        set.add(number)
    }
}