package lesson4.test3

fun main() {
    val array = mutableListOf<CharArray>().apply {
        repeat(10) {
            val tempArray = readln().trim().toCharArray()
            add(tempArray)
        }
    }

    val points = mutableSetOf<Pair<Int, Int>>()
    for (i in array.indices) {
        for (j in array[i].indices) {
            if (array[i][j] == '#') {
                points.add(i to j)
            }
        }
    }

    if (points.size != 20) {
        println("NO")
        return
    }

    val pointsCopy = points.toList()
    for (point in pointsCopy) {

        for (i in (point.first)..(point.first + 1)) {
            for (j in (point.second)..(point.second + 1)) {

                if (i == point.first && j == point.second) {
                    continue
                }

                if (Pair(i, j) in points) {
                    points.remove(i to j)
                }
            }
        }
    }

    if (points.size == 10) {
        println("YES")
    } else {
        println("NO")
    }
}