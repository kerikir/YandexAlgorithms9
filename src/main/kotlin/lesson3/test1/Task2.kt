package lesson3.test1

fun main() {
    val n = readln().trim().toInt()
    val sweets = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val types = mutableMapOf<Int, Int>()

    var currCount = 0
    var maxCount = 0
    var right = 0

    for (left in 0..<n) {
        while (right < n && types.size <= 2) {

            if (types.size == 2 && sweets[right] !in types) {
                currCount = right - left
                if (maxCount < currCount) {
                    maxCount = currCount
                }
                break

            } else {
                types[sweets[right]] = types.getOrDefault(sweets[right], 0) + 1
                right++
            }
        }

        if (right == n && types.size == 2) {
            currCount = right - left
            if (maxCount < currCount) {
                maxCount = currCount
            }
        }

        if (types.getOrDefault(sweets[left], 1) > 1) {
            types[sweets[left]] = types.getOrDefault(sweets[left], 1) - 1
        } else {
            types.remove(sweets[left])
        }
    }

    println(maxCount)
}