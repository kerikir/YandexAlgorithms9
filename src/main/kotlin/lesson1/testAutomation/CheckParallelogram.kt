package lesson1.testAutomation

/*

Задача: Построение параллелограмма - определить можно ли построить параллелограмм по точкам

Сложность = O(N * K * logK)
Ограничения: 1 <= N <= 10
             -100 <= X, Y <= 100

Время = 124ms
Память = 20.88MB

 */


fun main() {
    val n = readln().trim().toInt()
    val pointsStr = mutableListOf<String>()
    repeat(n) {
        val str = readln().trim()
        pointsStr.add(str)
    }

    repeat(n) { iteration ->

        val points = pointsStr[iteration]
            .split(Regex("\\s+"))
            .map { it.toInt() }
            .chunked(2)
            .map { coords -> coords[0] to coords[1] }

        val pointsSorted = points.sortedBy { it.first }

        isParallelogram(pointsSorted).also {
            if (it) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}


fun calculateDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
    return (p2.first - p1.first) * (p2.first - p1.first) + (p2.second - p1.second) * (p2.second - p1.second)
}


fun isParallelogram(points: List<Pair<Int, Int>>): Boolean {

    val ab = calculateDistance(points[0], points[1])
    val dc = calculateDistance(points[2], points[3])

    val bc = calculateDistance(points[1], points[3])
    val ad = calculateDistance(points[0], points[2])

    return ab == dc && bc == ad
}