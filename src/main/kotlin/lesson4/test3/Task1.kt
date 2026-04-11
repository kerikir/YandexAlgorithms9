package lesson4.test3

fun main() {
    val list = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toMutableList()

    var sum = 0
    while (list.size >= 3) {
        val (a, b) = findBallsRow(list)
        if (a == -1 && b == -1) {
            break
        }

        sum += b - a + 1
        for (i in b downTo a) {
            list.removeAt(i)
        }
    }

    println(sum)
}


fun findBallsRow(list: List<Int>): Pair<Int, Int> {
    var left = 0
    var right = 0
    var currentLength = 0

    var maxLength = 0
    var maxLeft = 0
    var maxRight = 0

    var lastNumber = -1
    for (i in list.indices) {
        if (lastNumber != list[i]) {
            currentLength = 1
            lastNumber = list[i]
            left = i
        } else {
            currentLength++
            right = i

            if (currentLength > maxLength) {
                maxLength = currentLength
                maxLeft = left
                maxRight = right
            }
        }
    }

    return if (maxLength >= 3) {
        maxLeft to maxRight
    } else {
        -1 to -1
    }
}