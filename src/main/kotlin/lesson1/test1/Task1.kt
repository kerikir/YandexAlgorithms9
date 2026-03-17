package lesson1.test1

fun main() {

    val (n, m) = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val charArray = Array<CharArray>(n) {
        readln().trim().toCharArray()
    }

    var counter = 0

    for (i in 0..<n) {
        for (j in 0..<m) {
            if (j != m - 1) {
                if (charArray[i][j] == '.' && charArray[i][j + 1] == '.')
                    counter++
            }

            if (i != n - 1) {
                if (charArray[i][j] == '.' && charArray[i + 1][j] == '.')
                    counter++
            }
        }
    }

    println(counter)
}