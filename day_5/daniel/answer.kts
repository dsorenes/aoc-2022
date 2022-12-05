package day5

import java.io.File
import kotlin.math.max

val lines = File("input.txt").readLines()

fun parseStackDrawing(input: List<String>): MutableList<MutableList<Char>> {
    val stackIndices = input[8]

    val setup = input.take(8)

    val cargo = MutableList(9) { mutableListOf<Char>() }
    var cargoIndex = 0
    stackIndices.mapIndexed { index, ch ->
        ch.toString().toIntOrNull()?.let {
            setup.forEach {crate ->
                if (index < crate.length) {
                    cargo[cargoIndex].add(crate[index])
                }
            }
            cargoIndex++
        }
    }

    return cargo
        .map { it
            .filter { c -> c.toString() != " " }
            .toMutableList()
        }
        .toMutableList()
}

var cargo = parseStackDrawing(lines)

val moves = lines.takeLast(lines.size - 10)

fun part1(input: List<String>) {
    input.forEach { move ->
        val (_, amount, _, from, _) = move.split(" ")
        val to = move.split(" ").last().toInt() - 1
        val fromInt = from.toInt() - 1

        val toTake = max(cargo[fromInt].size - amount.toInt(), 0)
        val itemsToMove = cargo[fromInt].take(amount.toInt())
        itemsToMove.forEach { crate ->
            cargo[to].add(0, crate)
        }
        cargo[fromInt] = cargo[fromInt].takeLast(toTake).toMutableList()
    }

    cargo.forEach { print(it.take(1)[0]) }
    println()
}


part1(moves)
cargo = parseStackDrawing(lines)

fun part2(input: List<String>) {
    input.forEach { move ->
        val (_, amount, _, from, _) = move.split(" ")
        val to = move.split(" ").last().toInt() - 1
        val fromInt = from.toInt() - 1

        val toTake = max(cargo[fromInt].size - amount.toInt(), 0)
        val itemsToMove = cargo[fromInt].take(amount.toInt())
        if (amount.toInt() > 1) {
            cargo[to].addAll(0, itemsToMove)
        } else {
            itemsToMove.forEach { crate ->
                cargo[to].add(0, crate)
            }
        }
        cargo[fromInt] = cargo[fromInt].takeLast(toTake).toMutableList()
    }

    cargo.forEach { print(it.take(1)[0]) }
    println()
}
part2(moves)