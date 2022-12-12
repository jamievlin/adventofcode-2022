package th.`in`.jamievl.adventofcode.d3

import th.`in`.jamievl.adventofcode.common.readFromResource

fun getElementPriority(charVal: Char) : Int {
    return when (charVal) {
        in 'a'..'z' -> 1 + (charVal - 'a')
        in 'A'..'Z' -> 27 + (charVal - 'A')
        else -> 0
    }
}

fun calculateGroupTagPriority(groupItemChar: List<Set<Char>>): Int {
    val commonIntersectionGroup = groupItemChar.reduce { reducedSet, currSet ->
        reducedSet intersect currSet
    }
    return getElementPriority(commonIntersectionGroup.elementAt(0))
}

fun main() {
    var totalPriority = 0
    var groupTagCounter = 0
    var groupTagPriority = 0
    val commonItems =  ArrayList<Set<Char>>()

    readFromResource("d3/d3_input.txt") { line ->
        // part 1
        val s1 = line.substring(0 until (line.length / 2))
        val s2 = line.substring(line.length/2)

        val commonChars = s1.toSet()
            .intersect(s2.toSet())

        val commonChar = commonChars.elementAt(0)
        totalPriority += getElementPriority(commonChar)

        // part 2
        commonItems.add(line.toSet())
        groupTagCounter = (groupTagCounter + 1) % 3

        if (groupTagCounter == 0) {
            groupTagPriority += calculateGroupTagPriority(commonItems)
            commonItems.clear()
        }
    }

    println("total priority: $totalPriority")
    println("group priority: $groupTagPriority")
}
