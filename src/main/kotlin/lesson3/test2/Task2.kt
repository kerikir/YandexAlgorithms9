package lesson3.test2

/*

Задача: Очередь в столовую - определить, на какое минимальное по счёту место может встать Женя

Сложность = O(N)
Ограничения: 1 <= N <= 100_000
             1 <= M <= 10_000
             1 <= D, Ti, Ki <= 1_000_000_000

Время = 2s
Память = 56.44MB

 */


fun main() {
    val cases = readln().trim().toInt()

    repeat(cases) {
        val (n, d) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        val t = IntArray(n)
        val k = IntArray(n)
        repeat(n) {
            val (ti, ki) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
            t[it] = ti
            k[it] = ki
        }

        val prefixSumWait = LongArray(n)
        prefixSumWait[0] = d.toLong()
        for (i in 1..<n) {
            prefixSumWait[i] = prefixSumWait[i - 1] + k[i - 1]
        }

        var place = n + 1
        while (place > 1 && prefixSumWait[place - 2] <= t[place - 2]) {
            place--
        }

        println(place)
    }
}