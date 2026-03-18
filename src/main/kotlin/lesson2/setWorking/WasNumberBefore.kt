package lesson2.setWorking

fun main() {
    val numbers = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val set = mutableSetOf<Int>()
    for (number in numbers) {

        if (set.contains(number)) {
            println("YES")
        } else {
            println("NO")
        }

        set.add(number)
    }
}