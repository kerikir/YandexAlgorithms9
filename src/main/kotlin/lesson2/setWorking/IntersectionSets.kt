package lesson2.setWorking

fun main() {
    val array1 = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val array2 = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val set1 = array1.toSet()
    val set2 = array2.toSet()

    val result = set1.intersect(set2).sorted()
    println(result.joinToString(" "))
}