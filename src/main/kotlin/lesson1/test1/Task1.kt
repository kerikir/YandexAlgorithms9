package lesson1.test1

/*

Задача: Размещение предмета - определить количество способов, которыми можно разместить предмет в помещении

Сложность = O(N * M)
Ограничения: 0 <= N, M <= 1_000

Время = 362ms
Память = 31.26MB

 */


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