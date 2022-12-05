package day4

import java.io.File

var totalPart1 = 0
var totalPart2 = 0
File("input.txt").forEachLine { line ->
    val (firstElf, secondElf) = line
        .split(",")
        .map { it.split("-") }
        .map { Pair(it.first().toInt(), it.last().toInt()) }
        .map { (first, second) -> listOf(first..second).flatten() }

    if (firstElf.containsAll(secondElf) || secondElf.containsAll(firstElf)) {
        totalPart1++
    }

    if (firstElf.any(secondElf::contains) || secondElf.any(firstElf::contains)) {
        totalPart2++
    }

}
println(totalPart1)
println(totalPart2)
