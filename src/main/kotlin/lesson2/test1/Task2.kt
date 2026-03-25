package lesson2.test1

fun main() {
    val n = readln().trim().toInt()
    val strings = mutableListOf<String>().apply {
        repeat(n) {
            val str = readln().trim()
            add(str)
        }
    }

    val maxLength = strings.first().length

    for (k in maxLength downTo 1) {

        val map = mutableMapOf<String, Int>()
        var index = 0

        while (map.size <= n / 2) {
            val subStr = strings[index].substring(0, k)
            map[subStr] = map.getOrDefault(subStr, 0) + 1

            index++

            if (index == n) {
                if (map.all { it.value % 2 == 0 }) {
                    println(k)
                    return
                }
            }
        }
    }

    println(0)
}