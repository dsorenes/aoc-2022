package aoc.day4


fun main() {
    val items = Input.ITEMS.split('\n').map { item -> item.trim() }

    val seats = items.filter { item ->
        val (first, second) = item.split(',').map { row -> row.split('-') }
        val (seat1, seat2) = first.map { seat -> seat.toInt() }
        val (seat3, seat4) = second.map { seat -> seat.toInt() }

        val contains1 = seat1 >= seat3 && seat2 <= seat4
        val contains2 = seat3 >= seat1 && seat4 <= seat2

        contains1 || contains2
    }

    println("Part 1: ${seats.size}")

    val seats2 = items.filter { item ->
        val (first, second) = item.split(',').map { row -> row.split('-') }
        val (seat1, seat2) = first.map { seat -> seat.toInt() }
        val (seat3, seat4) = second.map { seat -> seat.toInt() }

        seat1 in seat3..seat4 || seat2 in seat3..seat4 || seat3 in seat1..seat2 || seat4 in seat1..seat2
    }

    println("Part 2: ${seats2.size}")
}