package lesson2.sets

fun main() {
    val n = readln().trim().toInt()

    val languages = mutableListOf<MutableSet<String>>()
    repeat(n) {
        val m = readln().trim().toInt()

        val lang = mutableSetOf<String>().apply {
            repeat(m) {
                add(readln().trim())
            }
        }

        languages.add(lang)
    }


}