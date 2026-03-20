package lesson2.dictionaries

import java.io.File

fun main() {
    val text = File("input.txt").readText().trim().split(Regex("\\n"))

    val operations = mutableListOf<List<String>>().apply {
        for (line in text) {
            add(line.trim().split(Regex("\\s+")))
        }
    }

    val accounts = mutableMapOf<String, Int>()
    val output = mutableListOf<String>()

    for (operation in operations) {
        when(operation[0]) {
            "DEPOSIT" -> {
                accounts[operation[1]] = accounts.getOrDefault(operation[1], 0) + operation[2].toInt()
            }

            "INCOME" -> {
                accounts.forEach { name, sum ->
                    if (sum > 0) {
                        accounts[name] = (sum * (100 + operation[1].toInt()) / 100.0).toInt()
                    }
                }
            }

            "BALANCE" -> {
                val info = if (accounts.contains(operation[1])) {
                    accounts[operation[1]].toString()
                } else {
                    "ERROR"
                }
                output.add(info)
            }

            "WITHDRAW" -> {
                accounts[operation[1]] = accounts.getOrDefault(operation[1], 0) - operation[2].toInt()
            }

            "TRANSFER" -> {
                accounts[operation[1]] = accounts.getOrDefault(operation[1], 0) - operation[3].toInt()
                accounts[operation[2]] = accounts.getOrDefault(operation[2], 0) + operation[3].toInt()
            }
        }
    }

    println(output.joinToString("\n"))
}