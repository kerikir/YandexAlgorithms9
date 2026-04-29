package lesson2.test1

/*

Задача: Настольный баскетбол - определить кто из игроков набрал больше всего очков

Сложность = O(M)
Ограничения: 1 <= N <= 50
             1 <= M <= 500

Время = 204ms
Память = 22.56MB

 */

fun main() {
    val n = readln().trim().toInt()
    val names = mutableListOf<String>().apply {
        repeat(n) {
            val name = readln().trim()
            add(name)
        }
    }
    val m = readln().trim().toInt()
    var leftScore = 0
    var rightScore = 0

    val map = mutableMapOf<String, Int>().apply {
        repeat(m) {
            val (score, name) = readln().trim().split(Regex("\\s+"))
            val (a, b) = score.trim().split(":").map { it.toInt() }
            if (a != leftScore) {
                this[name] = this.getOrDefault(name, 0) + (a - leftScore)
                leftScore = a
            } else if (b != rightScore) {
                this[name] = this.getOrDefault(name, 0) + (b - rightScore)
                rightScore = b
            }
        }
    }

    map.maxBy { it.value }.also {
        println("${it.key} ${it.value}")
    }
}