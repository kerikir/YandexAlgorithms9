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
    if (max == 1) {
        println(s.length)
        return
    }

    val indices =  mutableMapOf<Char, MutableList<Int>>()
    for (index in s.indices) {
        if (s[index] in symbols) {
            indices.getOrPut(s[index]) {
                mutableListOf()
            }.add(index)
        }
    }

    var currLength = 1
    var maxLength = 1

    for (list in indices.values) {
        var flag = true
        currLength = 1

        while ((list.last() + currLength < s.length) && (list[0] + currLength < list[1])) {

            for (i in 0..<(max - 1)) {
                flag = s[list[i] + currLength] == s[list[i + 1] + currLength]
            }

            if (flag) {
                currLength++

                if (currLength > maxLength) {
                    maxLength = currLength
                }
            } else {
                break
            }
        }
    }

    println(maxLength)
}