package th.`in`.jamievl.adventofcode.d1

import th.`in`.jamievl.adventofcode.common.readFromResource

fun main() {
    val caloriesList = ArrayList<Int>()
    var currCounter = 0

    readFromResource("d1/d1_input.txt") {
        if (it.isNotEmpty()) {
            currCounter += it.toInt()
        } else {
            caloriesList.add(currCounter)
            currCounter = 0
        }
    }

    println("max calories: ${caloriesList.max()}")

    val calListSorted = caloriesList.sortedDescending()
    val first3Sum = calListSorted.slice(IntRange(0, 2)).sum()

    println("max calories of 3 : $first3Sum")
}
