package day3

import java.io.File

// part 1
var prioritySum = 0
val alphabet = ('a'..'z').toMutableList() + ('A'..'Z').toMutableList()
File("input.txt").forEachLine {
    var firstItem = ""
    var secondItem = ""

    for (i in 0..it.length - 1) {
        if (i <= (it.length / 2) - 1) {
            firstItem = firstItem + it[i]
        } else {
           secondItem = secondItem + it[i]
        }
    }

    for (i in firstItem) {
        if (secondItem.contains(i.toChar())) {
            var priority = alphabet.indexOf(i) + 1
            prioritySum += priority
            break
        }
    }
}

println(prioritySum)

// part 2
prioritySum = 0
var lines = File("input.txt").readLines()

for (i in 0 until lines.size step 3) {
    var group = lines.subList(i, i + 3)

    for (c in group[0]) {
        if (group[1].contains(c) && group[2].contains(c)) {
            prioritySum += alphabet.indexOf(c) + 1
            break
        }
    }
}

println(prioritySum)
