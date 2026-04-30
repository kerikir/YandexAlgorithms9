package lesson3.test1

/*

Задача: Школа танцев - определить количество вариантов выбора требуемой группы

Сложность = O(N)
Ограничения: 1 <= N <= 1_000_000

Время = 647ms
Память = 99.27MB

 */


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