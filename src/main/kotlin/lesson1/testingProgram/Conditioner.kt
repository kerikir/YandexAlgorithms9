package lesson1.testingProgram

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