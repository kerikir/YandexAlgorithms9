package lesson3.twoPointers

fun main() {
    val (n, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val str = readln().trim()

    val chars = mutableMapOf<Char, Int>()

    var currentLength = 0
    var maxLength = 0

    var start = 1

    var left = 0
    for (right in 0..<n) {
        chars[str[right]] = chars.getOrDefault(str[right], 0) + 1

        while (chars.getValue(str[right]) > k) {
            chars[str[left]] = chars.getOrDefault(str[left], 1) - 1
            left++
        }

        currentLength = right - left + 1
        if (currentLength > maxLength) {
            maxLength = currentLength
            start = left + 1
        }
    }

    println("$maxLength $start")
}