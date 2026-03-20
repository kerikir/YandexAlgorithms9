package lesson2.dictionaries

/*

Задача: Словарь синонимов - определить синоним к переданному слову

Сложность = O(N)
Ограничения: нет данных

Время = 865ms
Память = 60.98MB

 */


fun main() {
    val n = readln().trim().toInt()
    val synonyms = mutableMapOf<String, String>().apply {
        repeat(n) {
            val (a, b) = readln().trim().split(Regex("\\s+"))
            this[a] = b
            this[b] = a
        }
    }

    val word = readln().trim()

    println(synonyms[word] ?: "")
}