package lesson3.twoPointers

fun main() {
    val (n, k) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val trees = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    var counter = 0

    val varieties = IntArray(k)
    for (i in 0..<k) {
        val index = trees[i] - 1

        if (varieties[index] == 0) {
            counter++
        }

        varieties[index]++
    }

    if (counter == k) {
        println("1 $k")
        return
    }

    var start = 0
    var finish = k

    var currentLength = k
    var minLength = n

    var left = 0
    var right = k

    while (left < n && right < n) {
        val variate = trees[right] - 1
        if (varieties[variate] == 0) {
            counter++
        }
        varieties[variate]++

        if (counter == k) {
            currentLength = right - left

            if (currentLength < minLength) {
                minLength = currentLength
                start = left + 1
                finish = right + 1
            }

            while (counter == k) {
                val removeVariate = trees[left] - 1
                left++

                varieties[removeVariate]--
                if (varieties[removeVariate] == 0) {
                    counter--
                } else {
                    currentLength = right - left

                    if (currentLength < minLength) {
                        minLength = currentLength
                        start = left + 1
                        finish = right + 1
                    }
                }
            }
        }

        right++
    }

    println("$start $finish")
}