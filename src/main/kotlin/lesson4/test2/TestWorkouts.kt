package lesson4.test2

/*

Задача: Тестовые тренировки - определить количество пар похожих работ

Сложность = O(M^2 * N) = O(M^3)
Ограничения: 1 <= N <= 100
             1 <= M <= 100

Время = 261ms
Память = 22.56MB

 */


fun main() {
    val n = readln().trim().toInt()
    val correctAnswers = readln().trim()
    val m = readln().trim().toInt()
    val answers = mutableListOf<String>().apply {
        repeat(m) {
            val ans = readln().trim()
            add(ans)
        }
    }

    var result = mutableListOf<Pair<Int, Int>>()

    for (i in 0..<(m - 1)) {
        for (j in (i + 1)..<m) {
            if (isSimilarWorks(correctAnswers, answers[i], answers[j])) {
                result.add(i + 1 to j + 1)
            }
        }
    }

    println(result.size)
    result.forEach {
        println("${it.first} ${it.second}")
    }
}


fun isSimilarWorks(correctWork: String, work1: String, work2: String): Boolean {

    var correctAnswers = 0
    var incorrectAnswers = 0
    var correctAnswers2 = 0
    var incorrectAnswers2 = 0
    var matchCorrectAnswers = 0
    var matchInCorrectAnswers = 0
    var matchCorrectAnswers2 = 0
    var matchInCorrectAnswers2 = 0

    for (i in correctWork.indices) {
        if (correctWork[i] == work1[i]) {
            correctAnswers++
            if (work1[i] == work2[i]) {
                matchCorrectAnswers++
            }

        } else {
            incorrectAnswers++
            if (work1[i] == work2[i]) {
                matchInCorrectAnswers++
            }
        }

        if (correctWork[i] == work2[i]) {
            correctAnswers2++
            if (work1[i] == work2[i]) {
                matchCorrectAnswers2++
            }

        } else {
            incorrectAnswers2++
            if (work1[i] == work2[i]) {
                matchInCorrectAnswers2++
            }
        }
    }

    return (2 * matchCorrectAnswers > correctAnswers) && (2 * matchInCorrectAnswers > incorrectAnswers) &&
            (2 * matchCorrectAnswers2 > correctAnswers2) && (2 * matchInCorrectAnswers2 > incorrectAnswers2)
}