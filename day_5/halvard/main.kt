package aoc.day5

fun main() {
    val crates = Input.CRATES.split('\n').toMutableList()
    val lines = crates.last()
    crates.remove(lines)

    val queues = mutableListOf<MutableList<Char>>()
    lines.forEachIndexed {index, text -> if (text != ' ') queues.add(crates.map { ch -> ch[index] }.filter {ch -> ch != ' '}.toMutableList())}

    val moves = Input.MOVES.split('\n').map { item -> item.trim() }

    moves.forEach {move -> run {
        val (number, from, to) = move.split(' ').map { str -> str.toIntOrNull() }.filterNotNull()
        for (i in 1..number) queues[to - 1].add(0, queues[from - 1].removeFirst())
    }}
    println("Part 1: ${queues.map{ch -> ch[0]}.joinToString("")}")


    val crates2 = Input.CRATES.split('\n').toMutableList()
    val lines2 = crates2.last()
    crates2.remove(lines)

    val queues2 = mutableListOf<MutableList<Char>>()
    lines2.forEachIndexed {index, text -> if (text != ' ') queues2.add(crates2.map { ch -> ch[index] }.filter {ch -> ch != ' '}.toMutableList())}

    moves.forEach {move -> run {
        val (number, from, to) = move.split(' ').map { str -> str.toIntOrNull() }.filterNotNull()
        val newQueue = mutableListOf<Char>()
        for (i in 1..number) newQueue.add(queues2[from - 1].removeFirst())
        queues2[to - 1].addAll(0, newQueue)
    }}
    println("Part 2: ${queues2.map{ch -> ch[0]}.joinToString("")}")
}