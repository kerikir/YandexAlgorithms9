package test

fun main() {
    val n = readln().toInt()
    val capitalization = readln().trim().split(" ").map { it.toLong() }

    val prefixSum = LongArray(n)
    prefixSum[0] = capitalization[0]
    val mergerArray = LongArray(n)
    mergerArray[0] = capitalization[0]

    for (i in 1 until n) {
        prefixSum[i] = prefixSum[i - 1] + capitalization[i]

        if (capitalization[i] > capitalization[i - 1]) {
            // Скупаем в любом порядке
            mergerArray[i] = prefixSum[i]

        } else if (mergerArray[i - 1] > capitalization[i - 1]) {
            // Скупаем сначала маленькие
            mergerArray[i] = prefixSum[i]

        } else {
            // Скупить не получится
            mergerArray[i] = mergerArray[i - 1]
        }
    }

    val result = mutableListOf<Int>()
    if (mergerArray[capitalization.lastIndex] > capitalization[capitalization.lastIndex - 1]) {
        result.add(1)
    } else {
        result.add(0)
    }

    for (i in (mergerArray.lastIndex - 1) downTo 0) {

        if (mergerArray[i] > capitalization[i + 1] && result.first() == 1) {
            // Покупаем компанию, которая позволяет скупить все
            result.add(0, 1)
        } else {
            result.add(0, 0)
        }
    }

    println(result.joinToString("\n"))
}