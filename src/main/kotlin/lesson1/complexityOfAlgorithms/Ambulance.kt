package lesson1.complexityOfAlgorithms

import kotlin.math.max


fun main() {
    val (k1, m, k2, p2, n2) = readln().trim()
        .split(Regex("\\s+"))
        .map { it.toInt() }


}


fun calculateApartment(k1: Int, m: Int, k2: Int, p2: Int, n2: Int): Pair<Int, Int> {

    if (n2 > m || m <= 0 || k2 <= 0 || p2 <= 0 || n2 <= 0 || k1 <= 0) return -1 to -1

    val maxK = max(k1, k2)

    var p1: Int = -1
    var n1: Int = -1

    for (c in 1..maxK) {

    }
}


fun checkApartmentsPerFloor(k1: Int, m: Int, k2: Int, p2: Int, n2: Int, apartmentsPerFloor: Int)
: Pair<Int, Int> {


}


fun getEntranceAndFloor(k: Int, m: Int, apartmentsPerFloor: Int): Pair<Int, Int> {

    val apartmentsPerEntrance = m * apartmentsPerFloor

    val p = (k - 1) / apartmentsPerEntrance + 1
    val apartmentInEntrance = (k - 1) % apartmentsPerEntrance + 1
    val n = (apartmentInEntrance - 1) / apartmentsPerFloor + 1

    return p to n
}