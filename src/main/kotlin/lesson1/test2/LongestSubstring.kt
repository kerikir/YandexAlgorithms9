package lesson1.test2

/*

Задача: Ахаха - определить самую длинную подстроку

Сложность = O(N)
Ограничения: 0 <= N <= 100_000

Время = 184ms
Память = 21.14MB

 */


fun main() {
    val n = readln().trim().toInt()
    val msg = readln().trim()

    var left = 0
    var maxLength = 0
    var currLength = 0

    while (left < n) {

        if (msg[left] == 'a' || msg[left] == 'h') {

            if (left > 0 && msg[left] != msg[left - 1]) {
                currLength++
            } else if (left == 0) {
                currLength++
            } else {
                currLength = 1
            }

            if (currLength > maxLength) {
                maxLength = currLength
            }

        } else {
            currLength = 0
        }

        left++
    }

    println(maxLength)
}