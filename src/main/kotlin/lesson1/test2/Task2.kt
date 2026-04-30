package lesson1.test2

/*

Задача: Упаковка простыни - определить необходимое количество складываний

Сложность = O(logN)
Ограничения: 1 <= N, M, H, W <= 1_000_000_000_000_000_000

Время = 132ms
Память = 21.01MB

 */


fun main() {
    var (n, m, h, w) = readln().trim().split(Regex("\\s+")).map { it.toLong() }

    var counter = 0

    while (!isCorrect(n, m, h, w)) {

        if (h < n && h < m) {
            h *= 2
            counter++
        } else if (w < n && w < m) {
            w *= 2
            counter++
        } else if (h in m..<n) {
            w *= 2
            counter++
        } else if (w in m..<n) {
            counter++
            h *= 2
        } else {
            if (h > w) {
                h *= 2
            } else {
                w *= 2
            }
            counter++
        }
    }

    println(counter)
}


fun isCorrect(n: Long, m: Long, h: Long, w: Long): Boolean {
    return (n <= h && m <= w) || (n <= w && m <= h)
}