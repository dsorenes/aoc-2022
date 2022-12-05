import java.io.File

// part 1
var prioritySum = 0
val alphabet = ('a'..'z').toMutableList() + ('A'..'Z').toMutableList()

var lines = File("input.txt").readLines()
lines.forEach { line ->
    val firstItem = line.slice(0 until (line.length / 2))
    val secondItem = line.slice(line.length / 2 until line.length)

    for (i in firstItem) {
        if (secondItem.contains(i)) {
            prioritySum += alphabet.indexOf(i) + 1
            break
        }
    }
}
println(prioritySum)

// part 2
prioritySum = 0
for (i in lines.indices step 3) {
    val group = lines.subList(i, i + 3)

    for (c in group[0]) {
        if (group[1].contains(c) && group[2].contains(c)) {
            prioritySum += alphabet.indexOf(c) + 1
            break
        }
    }
}
println(prioritySum)