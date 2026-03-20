package lesson2.dictionaries

import java.io.BufferedReader
import java.io.FileReader
import java.util.TreeMap

fun main() {
    val buyers = sortedMapOf<String, TreeMap<String, Long>>()

    val text = BufferedReader(FileReader("input.txt"))
    text.useLines { lines ->
        lines.forEach { line ->

            if (line.isNotBlank()) {
                val (name, item, count) = line.trim().split(Regex("\\s+"))
                val buyer = buyers.getOrPut(name) { TreeMap() }
                buyer[item] = buyer.getOrDefault(item, 0L) + count.toLong()
            }
        }
    }

    StringBuilder().apply {
        for ((name, items) in buyers) {
            append("$name:\n")

            for ((item, count) in items) {
                append("$item $count\n")
            }
        }
    }.toString().also(::println)
}