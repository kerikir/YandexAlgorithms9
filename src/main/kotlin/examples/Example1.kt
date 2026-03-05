package examples

fun main() {
    val msg = readln()

    val reverseResult = mutableListOf<Char>()
    var i = msg.length - 1

    while (i >= 0) {

        if (msg[i] == '#') {
            val number = msg.subSequence(i - 2, i).toString().toInt()
            val char = (97 + number - 1).toChar()
            reverseResult.add(char)
            i -= 3

        } else {
            val number = msg[i].digitToInt()
            val char = (97 + number - 1).toChar()
            reverseResult.add(char)
            i--
        }
    }

    println(reverseResult.reversed().joinToString(""))
}