package lesson2.dictionaries

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