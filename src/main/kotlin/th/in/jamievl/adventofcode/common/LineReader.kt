package th.`in`.jamievl.adventofcode.common


fun readFromResource(fileName: String, processFn: (String) -> Unit) {
    val inputFile = ClassLoader.getSystemResourceAsStream(fileName)!!

    with(inputFile.bufferedReader()) {
        var line = this.readLine()
        while (line != null) {
            processFn(line)

            line = this.readLine()
        }
    }
}
