package th.`in`.jamievl.adventofcode.d3

import th.`in`.jamievl.adventofcode.common.readFromResource

fun getElementPriority(charVal: Char) : Int {
    return when (charVal) {
        in 'a'..'z' -> 1 + (charVal - 'a')
        in 'A'..'Z' -> 27 + (charVal - 'A')
        else -> 0
    }
}

fun main() {
    var totalPriority = 0

    readFromResource("d3/d3_input.txt") { line ->
        val s1 = line.substring(0 until (line.length / 2))
        val s2 = line.substring(line.length/2)

        val commonChars = s1.toSet()
            .intersect(s2.toSet())

        val commonChar = commonChars.elementAt(0)
        totalPriority += getElementPriority(commonChar)
    }

    print("total priority: $totalPriority")
}
