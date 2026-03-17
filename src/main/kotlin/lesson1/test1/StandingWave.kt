package lesson1.test1

/*

Задача: Колебание струны - определить положение струны на отрезке после влияния сил

Сложность = O(N * M)
Ограничения: 0 <= N, M <= 1_000
             1 <= L, R <= 1_000_000_000
             1 <= F <= 1_000

Время = 410ms
Память = 27.09MB

 */


fun main() {
    val (n, m) = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val x = mutableListOf<Int>()
    val l = mutableListOf<Int>()
    val r = mutableListOf<Int>()
    repeat(n) {
        val (li, ri, xi) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        l.add(li)
        r.add(ri)
        x.add(xi)
    }

    val info = mutableListOf<Int>()
    repeat(m) {
        val qi = readln().trim().toInt()
        info.add(qi)
    }

    val result = mutableListOf<Int>()
    for (i in 0..<m) {
        val q = info[i]

        var h = 0
        for (j in 0..<n) {

            if (l[j] <= q && q <= r[j]) {
                val even = (q - l[j]) % 2 == 0
                if (even) {
                    h += x[j]
                } else {
                    h -= x[j]
                }
            }
        }

        result.add(h)
    }

    println(result.joinToString("\n"))
}