package lesson3.twoPointers

fun main() {
    val (n, r) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val d = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val distances = IntArray(n)
    for (i in 0..<n) {
        distances[i] = d[i] - d[0]
    }

    var counter = 0L

    var right = 0
    for (left in 0..<n) {
        while (right < n) {

            val distance = distances[right] - distances[left]
            if (distance > r) {
                counter += n - right
                break
            } else {
                right++
            }
        }
    }

    println(counter)
}