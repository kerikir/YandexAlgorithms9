package lesson1.test1

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