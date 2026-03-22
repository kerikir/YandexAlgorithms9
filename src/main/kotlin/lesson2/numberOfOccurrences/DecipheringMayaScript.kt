package lesson2.numberOfOccurrences

/*

Задача: Расшифровка письменности Майя - определить количество вхождений последовательности символов в текст

Сложность = O(N)
Ограничения: 1 <= N <= 3_000_000

Время = 855ms
Память = 39.4MB

 */


fun main() {
    val (g, s) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val w = readln().trim().map { it }
    val text = readln().trim()

    val symbolsInWord = mutableMapOf<Char, Int>()
    val symbolsInText = mutableMapOf<Char, Int>()

    for (symbol in w) {
        symbolsInWord[symbol] = symbolsInWord.getOrDefault(symbol, 0) + 1
    }

    for (i in 0..<g) {
        symbolsInText[text[i]] = symbolsInText.getOrDefault(text[i], 0) + 1
    }

    var counter = 0
    var degreeOfSimilarity = 0

    for (symbol in symbolsInWord.entries) {
        if (symbol.value == symbolsInText[symbol.key]) {
            degreeOfSimilarity++
        }
    }

    if (degreeOfSimilarity == symbolsInWord.size) counter++

    for (i in g..<s) {
        val leftSymbol = text[i - g]
        val nextSymbol = text[i]

        if (symbolsInWord[leftSymbol] == symbolsInText[leftSymbol]) {
            degreeOfSimilarity--

        } else if (symbolsInWord[leftSymbol] == symbolsInText[leftSymbol]!! - 1) {
            degreeOfSimilarity++
        }

        symbolsInText[leftSymbol] = symbolsInText.getOrDefault(leftSymbol, 0) - 1
        symbolsInText[nextSymbol] = symbolsInText.getOrDefault(nextSymbol, 0) + 1

        if (symbolsInWord[nextSymbol] == symbolsInText[nextSymbol]) {
            degreeOfSimilarity++

        } else if (symbolsInWord[nextSymbol] == symbolsInText[nextSymbol]!! - 1) {
            degreeOfSimilarity--
        }

        if (degreeOfSimilarity == symbolsInWord.size) counter++
    }

    println(counter)
}