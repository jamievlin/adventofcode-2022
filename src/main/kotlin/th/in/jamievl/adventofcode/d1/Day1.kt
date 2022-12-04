package th.`in`.jamievl.adventofcode.d1


fun main() {
    val inputFile = ClassLoader.getSystemResourceAsStream("d1/d1_input.txt")!!
    val caloriesList = ArrayList<Int>()

    with(inputFile.bufferedReader()) {
        var line = this.readLine()
        var currCounter = 0
        while (line != null) {
            if (line.isNotEmpty()) {
                currCounter += line.toInt()
            } else {
                caloriesList.add(currCounter)
                currCounter = 0
            }

            line = this.readLine()
        }
    }

    println("max calories: ${caloriesList.max()}")
}
