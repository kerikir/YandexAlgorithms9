package lesson2.test1

fun main() {
    val n = readln().trim().toInt()
    val names = mutableListOf<String>().apply {
        repeat(n) {
            val name = readln().trim()
            add(name)
        }
    }
    val m = readln().trim().toInt()
    val points = mutableMapOf<String, Int>()

    val map = mutableMapOf<String, Int>().apply {
        repeat(m) {
            val (score, name) = readln().trim().split(Regex("\\s+"))
            val (a, b) = score.trim().split(":").map { it.toInt() }
            this[name] = this.getOrDefault(name, 0) + a + b

            if (!points.contains(name)) {
                points[name] = a
            }
        }
    }

    map.maxBy { it.value }.also {
        println("${it.key} ${points[it.key]}")
    }
}