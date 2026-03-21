package lesson1.test3

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