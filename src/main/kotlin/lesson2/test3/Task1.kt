package lesson2.test3

fun main() {
    val string = readln().trim()

    val numbers = IntArray(10)
    for (char in string) {
        val number = char.digitToInt()
        numbers[number]++
    }

    var remain1 = listOf(1, 4, 7)
    var remain2 = listOf(2, 5, 8)

    var sum = 0
    for (i in numbers.indices) {
        if (numbers[i] > 0) {
            sum += numbers[i] * i
        }
    }

    if (sum % 3 == 1) {

        val prevSize =
        if (numbers.any { it in remain1 }) {
            removeNumber(numbers, remain1)
        } else {
            removeNumber(numbers, remain2)
            removeNumber(numbers, remain2)
        }

    } else if (sum % 3 == 2) {
        numbers.inde
        if (numbers.any { it in remain2 }) {
            removeNumber(numbers, remain2)
        } else {
            removeNumber(numbers, remain1)
            removeNumber(numbers, remain1)
        }
    }

    var result = mutableListOf<Int>()
    for (i in numbers.indices.reversed()) {
        repeat(numbers[i]) {
            result.add(i)
        }
    }

    println(result.joinToString(""))
}


fun removeNumber(numbers: IntArray, digitsRemove: List<Int>) {
    for (digit in digitsRemove) {
        if (numbers[digit] > 0) {
            numbers[digit]--
            return
        }
    }
}