package lesson2.numberOfOccurrences

/*

Задача: Палиндром - составить палиндром наибольшей длины из букв

Сложность = O(N * logM) = O(N)
Ограничения: 1 <= N <= 100_000
             1 <= M <= 26

Время = 303ms
Память = 25.27MB

 */


fun main() {
    val n = readln().trim().toInt()
    val string = readln().trim()

    val numberOfRepetitionsOfLetters = sortedMapOf<Char, Int>()
    for (letter in string) {
        numberOfRepetitionsOfLetters[letter] = numberOfRepetitionsOfLetters.getOrDefault(letter, 0) + 1
    }

    val singleLetter = numberOfRepetitionsOfLetters.firstNotNullOfOrNull {
        if (it.value % 2 == 1) {
            it
        } else {
            null
        }
    }?.key

    for (char in numberOfRepetitionsOfLetters.keys) {
        numberOfRepetitionsOfLetters[char] = numberOfRepetitionsOfLetters.getOrDefault(char, 0) / 2
    }

    val half = mutableListOf<Char>().apply {

        numberOfRepetitionsOfLetters.filter { it.value > 0 }.forEach {
            repeat(it.value) { _ ->
                add(it.key)
            }
        }
    }

    val result = if (singleLetter != null) {
        half.joinToString("") + singleLetter + half.reversed().joinToString("")
    } else {
        half.joinToString("") + half.reversed().joinToString("")
    }
    println(result)
}