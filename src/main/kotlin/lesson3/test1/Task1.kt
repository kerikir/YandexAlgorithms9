package lesson3.test1

fun main() {
    val n = readln().trim().toInt()
    val string = readln().trim()

    val pair = mutableMapOf<Int, Int>()

    var sum = 0
    pair[sum] = pair.getOrDefault(sum, 0) + 1

    var counter = 0L

    for (gender in string) {
        if (gender == 'a') {
            sum += 1
        }
        if (gender == 'b') {
            sum -= 1
        }

        if (sum in pair) {
            counter += pair.getOrDefault(sum, 0)
        }
        pair[sum] = pair.getOrDefault(sum, 0) + 1
    }

    println(counter)
}