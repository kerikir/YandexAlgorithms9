package lesson2.test1

/*

Задача: Парные k-префиксы - определить наибольшую подстроку

Сложность = O(N * log(S/N))
Ограничения: 1 <= N <= 2 * 100_000
             1 <= S <= 2 * 1_000_000

Время = 760ms
Память = 61.87MB

 */


fun main() {
    val n = readln().trim().toInt()
    val strings = mutableListOf<String>().apply {
        repeat(n) {
            val str = readln().trim()
            add(str)
        }
    }

    var right = strings.first().length
    var left = 0

    while (left < right) {

        val middle = (left + right + 1) / 2
        if (isCorrect(strings, n, middle)) {
            left = middle
        } else {
            right = middle - 1
        }
    }

    println(right)
}


fun isCorrect(strings: List<String>, n: Int, k: Int): Boolean {
    val map = mutableMapOf<String, Int>()
    var index = 0

    while (map.size <= n / 2) {
        val subStr = strings[index].substring(0, k)
        map[subStr] = map.getOrDefault(subStr, 0) + 1

        index++

        if (index == n) {
            return map.all { it.value % 2 == 0 }
        }
    }

    return false
}