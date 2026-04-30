package lesson4.test3

/*

Задача: Расстановка кораблей - определить корректно ли расставлены корабли для игры "Морской бой"

Сложность = O(N^2)
Ограничения: 1 <= N <= 10

Время = 121ms
Память = 20.89MB

 */


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

    val ships = mutableMapOf<Int, Int>()
    for (i in 1..4) {
        ships[i] = 0
    }

    for (point in points) {

        var rightPoint = point.first to point.second + 1
        var bottomPoint = point.first + 1 to point.second

        if (bottomPoint in pointsCopy) {
            var length = 1
            while (bottomPoint in pointsCopy) {
                length++
                bottomPoint = point.first + length to point.second
            }

            ships[length] = ships.getOrDefault(length, 0) + 1

        } else if (rightPoint in pointsCopy) {
            var length = 1
            while (rightPoint in pointsCopy) {
                length++
                rightPoint = point.first to point.second + length
            }

            ships[length] = ships.getOrDefault(length, 0) + 1

        } else {
            ships[1] = ships.getOrDefault(1, 0) + 1
        }

    }

    if (points.size == 10 && ships[1] == 4 && ships[2] == 3 && ships[3] == 2 && ships[4] == 1) {
        println("YES")
    } else {
        println("NO")
    }
}