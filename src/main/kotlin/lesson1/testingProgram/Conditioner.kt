package lesson1.testingProgram

/*

Задача: Кондиционер - регулирование температуры комнаты

Сложность = O(1)
Ограничения: -50 <= все числа <= 50

Время = 124ms
Память = 20.88MB

 */


fun main() {
    val (tRoom, tCond) = readln().trim()
        .split(Regex("\\s+"))
        .map { it.toInt() }
    val mode = readln().trim()

    var result = tRoom
    when {
        mode == "freeze" && tCond < tRoom -> result = tCond
        mode == "heat" && tCond > tRoom -> result = tCond
        mode == "auto" -> result = tCond
    }

    println(result)
}