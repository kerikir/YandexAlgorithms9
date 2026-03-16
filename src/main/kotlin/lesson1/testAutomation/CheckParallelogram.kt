package lesson1.testAutomation


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

        val point = points.first()
        val pointsSorted = points.sortedBy { calculateDistance(point, it) }
    }
}


fun calculateDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>): Int {
    return (p2.first - p1.first) * (p2.first - p1.first) + (p2.second - p1.second) * (p2.second - p1.second)
}