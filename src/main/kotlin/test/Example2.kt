package test

fun main() {
    val n = readln().toInt()
    val capitalization = readln().trim().split(" ").map { it.toInt() }

    val mergerArray = IntArray(n)
    mergerArray[0] = capitalization[0]
    for (i in 1 until n) {
        mergerArray[i] = capitalization[i] + mergerArray[i - 1]
    }

    val result = mutableListOf<Int>()
    if (capitalization[capitalization.lastIndex] > capitalization[capitalization.lastIndex - 1]) {
        result.add(1)
    } else {
        val numberOfCapitalizationLessMax = capitalization.count { it < capitalization[capitalization.lastIndex] }
        if (numberOfCapitalizationLessMax > 0) {
            result.add(1)
        } else {
            result.add(0)
        }
    }

    for (i in (capitalization.lastIndex - 1) downTo 0) {
        if (mergerArray[i] > capitalization[i + 1]) {
            result.add(0, 1)
        } else {
            result.add(0, 0)
        }
    }

    println(result.joinToString("\n"))
}