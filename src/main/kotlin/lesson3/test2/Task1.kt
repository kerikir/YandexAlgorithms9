package lesson3.test2

/*

Задача: Закраска клеток - определить количество клеток, закрашенных более одного раза

Сложность = O(N)
Ограничения: 1 <= N <= 1_000

Время = 117ms
Память = 20.11MB

 */


fun main() {
    val commands = readln().trim()

    val points = mutableMapOf<Pair<Int, Int>, Int>()

    var x = 0
    var y = 0
    points[0 to 0] = 1

    for (command in commands) {
        when(command) {
            'U' -> {
                y++
                points[x to y] = points.getOrDefault(x to y, 0) + 1
            }

            'D' -> {
                y--
                points[x to y] = points.getOrDefault(x to y, 0) + 1
            }

            'R' -> {
                x++
                points[x to y] = points.getOrDefault(x to y, 0) + 1
            }

            'L' -> {
                x--
                points[x to y] = points.getOrDefault(x to y, 0) + 1
            }
        }
    }

    points.count { it.value > 1 }.also(::println)
}