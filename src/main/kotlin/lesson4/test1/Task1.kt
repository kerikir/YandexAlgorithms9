package lesson4.test1

/*

Задача: Подсчет квадратов - определить количество бактерий на снимке

Сложность = O(N * M) = O(N^2)
Ограничения: 1 <= N, M <= 500

Время = 619ms
Память = 51.65MB

 */


fun main() {
    val (n, m) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val array = mutableListOf<CharArray>().apply {
        repeat(n) {
            val tempArray = readln().trim().toCharArray()
            add(tempArray)
        }
    }

    var currLength = 0
    val points = mutableMapOf<Pair<Int, Int>, Int>()
    for ((i, row) in array.withIndex()) {
        for ((j, char) in row.withIndex()) {
            if (char == '#') {
                currLength++
                points[i to j - currLength + 1] = currLength
            } else {
                currLength = 0
            }
        }
        currLength = 0
    }

    var counter = 0

    for ((coords, length) in points) {
        if (Pair(coords.first + 1, coords.second) !in points) {
            counter++
        }
    }

    println(counter)
}