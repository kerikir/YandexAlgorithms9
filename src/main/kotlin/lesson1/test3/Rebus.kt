package lesson1.test3

/*

Задача: Ребус - определить ответ на ребус

Сложность = O(N)
Ограничения: 1 <= N <= 100

Время = 128ms
Память = 21.27MB

 */


fun main() {
    val str = readln().trim().split(Regex("\\s+"))

    val result = mutableListOf<String>()
    for (word in str) {
        var letf = 0
        var right = 0

        while (word[letf] == '\'') {
            letf++
        }
        while (word[word.length - 1 - right] == '\'') {
            right++
        }

        result.add(word.substring(letf * 2, word.length - right * 2))
    }

    println(result.joinToString(""))
}