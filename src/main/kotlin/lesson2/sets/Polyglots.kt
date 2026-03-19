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

    var everyKnows = languages.first().toSet()
    for (i in 1..<n) {
        everyKnows = everyKnows.intersect(languages[i])
    }
    println(everyKnows.size)
    for (language in everyKnows) {
        println(language)
    }

    var leastOneKnows = languages.first()
    for (i in 1..<n) {
        for (language in languages[i]) {
            leastOneKnows.add(language)
        }
    }
    println(leastOneKnows.size)
    for (language in leastOneKnows) {
        println(language)
    }
}