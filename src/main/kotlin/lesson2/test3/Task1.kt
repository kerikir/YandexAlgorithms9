package lesson2.test3

fun main() {
    val string = readln().trim()
    val numbers = IntArray(10)
    for (char in string) {
        val number = char.digitToInt()
        numbers[number]++
    }

    var maxNumber = 0
    for (i in 9 downTo 0) {
        repeat(numbers[i]) {
            maxNumber = 10 * maxNumber + i
        }
    }

    val diffNumbers = numbers.count { it > 0 }
    val counterZero = numbers[0]

    if (diffNumbers == 1 && counterZero > 0) {
        println(string)
        return
    }

    if (maxNumber % 3 == 0) {
        println(maxNumber)
        return
    }

    var maxString = maxNumber.toString()
    if (diffNumbers == 1) {
        repeat(maxString.length) {
            maxString = maxString.substring(0, maxString.length - 1 - it)
            val number = maxString.toInt()

            if (number % 3 == 0) {
                println(number)
                return
            }
        }
    }

    var stringMax = StringBuilder(maxString)
    var max = 0
    for (i in string.lastIndex downTo 1) {
        for (j in (i - 1) downTo 0) {

            val char1 = maxString[i]
            val char2 = maxString[j]
            stringMax[i] = char2
            stringMax[j] = char1

            val num = stringMax.toString().toInt()
            if (num % 3 == 0 && num > max) {
                max = num
            }
        }
    }

    println(max)
}