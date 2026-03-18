package lesson2.setWorking

fun main() {
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val set = numbers.toSet()
    println(set.size)
}