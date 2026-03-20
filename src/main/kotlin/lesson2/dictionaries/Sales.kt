package lesson2.dictionaries

import java.io.BufferedReader
import java.io.FileReader
import java.util.TreeMap


/*

Задача: Продажи - определить список покупок каждого продавца каждого предмета в лексикографическом порядке

Сложность = O(N * logN)
Ограничения: нет данных

Время = 961ms
Память = 63.89MB

 */


fun main() {
    val buyers = sortedMapOf<String, TreeMap<String, Long>>()

    val text = BufferedReader(FileReader("input.txt"))
    text.useLines { lines ->
        lines.forEach { line ->

            if (line.isNotBlank()) {
                val (name, item, count) = line.split(' ')
                val buyer = buyers.getOrPut(name) { TreeMap() }
                buyer[item] = buyer.getOrDefault(item, 0L) + count.toLong()
            }
        }
    }
    text.close()

    StringBuilder().apply {
        for ((name, items) in buyers) {
            append("$name:\n")

            for ((item, count) in items) {
                append("$item $count\n")
            }
        }
    }.toString().also(::println)
}