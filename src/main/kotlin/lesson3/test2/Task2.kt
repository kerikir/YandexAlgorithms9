package lesson3.test2

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