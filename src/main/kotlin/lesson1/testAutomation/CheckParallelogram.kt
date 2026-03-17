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

        val pointsSorted = points.sortedWith(compareBy({ it.first }, { it.second }))

        isParallelogram(pointsSorted).also {
            if (it) {
                println("YES")
            } else {
                println("NO")
            }
        }
    }
}


fun isParallelogram(points: List<Pair<Int, Int>>): Boolean {

    return (points[1].first - points[0].first == points[3].first - points[2].first) &&
            (points[1].second - points[0].second == points[3].second - points[2].second)
}