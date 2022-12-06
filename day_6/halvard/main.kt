package aoc.day6

fun main() {
    for (i in 0..INPUT.length - 4) {
        val list = INPUT.substring(i..i+3)
        if (list.toSet().size == 4) {
            println("Part 1: ${i + 4}")
            break
        }
    }
    for (i in 0..INPUT.length - 14) {
        val list = INPUT.substring(i..i+13)
        if (list.toSet().size == 14) {
            println("Part 2: ${i + 14}")
            break
        }
    }
}