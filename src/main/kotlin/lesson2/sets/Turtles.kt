package lesson2.sets

/*

Задача: Черепахи - определить количество участников, которые говорят правдивые места

Сложность = O(N)
Ограничения: 1 <= N <= 10_000

Время = 375ms
Память = 37.25MB

 */


fun main() {
    val n = readln().trim().toInt()

    val places = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (a, b) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        places.add(a to b)
    }

    val possiblePlaces = mutableSetOf<Pair<Int, Int>>()
    for (i in 0..<n) {
        possiblePlaces.add(i to n - 1 - i)
    }

    places.intersect(possiblePlaces).also {
        println(it.size)
    }
}