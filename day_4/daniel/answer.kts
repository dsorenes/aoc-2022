package day4

import java.io.File


var totalPart1 = 0
var totalPart2 = 0
File("input.txt").forEachLine { line ->
    val (firstElf, secondElf) = line.split(",").map { it.split("-") }

    val firstSec = listOf(firstElf.first().toInt()..firstElf.last().toInt()).flatten()
    val secondSec = listOf(secondElf.first().toInt()..secondElf.last().toInt()).flatten()

    if (firstSec.containsAll(secondSec) || secondSec.containsAll(firstSec)) {
        totalPart1++
    }

    if (firstSec.any(secondSec::contains) || secondSec.any(firstSec::contains)) {
        totalPart2++
    }

}
println(totalPart1)
println(totalPart2)
