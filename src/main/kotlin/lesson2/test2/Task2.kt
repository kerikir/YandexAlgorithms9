package lesson2.test2

fun main() {
    val s = readln().trim()

    val chars = mutableMapOf<Char, Int>()
    for (char in s) {
        chars[char] = chars.getOrDefault(char, 0) + 1
    }

    val max = chars.maxBy { it.value }.value
    val symbols = chars.filter { it.value == max }

    if (symbols.size == 1) {
        println(1)
        return
    }

    val indices =  mutableListOf<Int>()
    val charList =  mutableListOf<Char>()
    for (i in s.indices) {
        if (s[i] in symbols) {
            charList.add(s[i])
            indices.add(i)
        }
    }

    var currLength = 0
    var maxLength = 1
    var counter = 0
    var maxCounter = 0
    for (count in 2..symbols.size) {
        for (i in 0..charList.size - count) {

            counter = 0

            val substring = charList.subList(i, i + count)

            var left = i + count
            while (left < charList.size) {
                if (s[left] == substring[counter]) {
                    counter++
                    if (maxCounter < counter) {
                        maxCounter = counter
                        maxLength = count
                    }
                } else {
                    counter = 0
                }
                left++
            }
        }
    }

    println(maxLength)
}