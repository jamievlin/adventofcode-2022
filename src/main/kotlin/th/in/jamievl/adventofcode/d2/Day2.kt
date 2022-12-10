package th.`in`.jamievl.adventofcode.d2

import java.lang.IllegalArgumentException

enum class WinState {
    LOSE, WIN, DRAW
}

enum class RpsPlay {
    ROCK, PAPER, SCISSORS;

    fun calculateOutcomePartScore() = when (this) {
        ROCK -> 1
        SCISSORS -> 3
        PAPER -> 2
    }

    companion object {
        private fun calculateOutcome(yourPlay: RpsPlay, opponent: RpsPlay): Int = when (yourPlay) {
            ROCK -> when (opponent) {
                SCISSORS -> 6
                PAPER -> 0
                ROCK -> 3
            }
            PAPER -> when (opponent) {
                SCISSORS -> 0
                PAPER -> 3
                ROCK -> 6
            }
            SCISSORS -> when (opponent) {
                SCISSORS -> 3
                PAPER -> 6
                ROCK -> 0
            }
        }

        private fun calculateFromDesiredOutcome(theirPlay: RpsPlay, result: WinState): RpsPlay = when (theirPlay) {
            ROCK -> when (result) {
                WinState.DRAW -> ROCK
                WinState.WIN -> PAPER
                WinState.LOSE -> SCISSORS
            }
            PAPER -> when (result) {
                WinState.DRAW -> PAPER
                WinState.WIN -> SCISSORS
                WinState.LOSE -> ROCK
            }
            SCISSORS -> when (result) {
                WinState.DRAW -> SCISSORS
                WinState.WIN -> ROCK
                WinState.LOSE -> PAPER
            }
        }

        fun calculateScore(yourPlay: RpsPlay, opponent: RpsPlay): Int =
            calculateOutcome(yourPlay, opponent) + yourPlay.calculateOutcomePartScore()

        fun calculateScoreFromDesiredOutcome(theirPlay: RpsPlay, result: WinState): Int {
            val yourPlay = calculateFromDesiredOutcome(theirPlay, result)
            val resultScore = when (result) {
                WinState.WIN -> 6
                WinState.LOSE -> 0
                WinState.DRAW -> 3
            }
            return resultScore + yourPlay.calculateOutcomePartScore()
        }
    }
}


fun main() {
    val inputFile = ClassLoader.getSystemResourceAsStream("d2/d2_input.txt")!!
    var totalScore = 0
    var secondPartScore = 0

    with(inputFile.bufferedReader()) {
        var line = this.readLine()
        while (line != null) {
            val yourPlay = line[2]
            val desiredOutcomeLine = line[2] // part 2
            val theirPlay = line[0]

            val yourEnum = when (yourPlay) {
                'X' -> RpsPlay.ROCK
                'Y' -> RpsPlay.PAPER
                'Z' -> RpsPlay.SCISSORS
                else -> throw IllegalArgumentException()
            }

            val desiredOutcome = when (desiredOutcomeLine) {
                'X' -> WinState.LOSE
                'Y' -> WinState.DRAW
                'Z' -> WinState.WIN
                else -> throw IllegalArgumentException()
            }

            val theirEnum = when (theirPlay) {
                'A' -> RpsPlay.ROCK
                'B' -> RpsPlay.PAPER
                'C' -> RpsPlay.SCISSORS
                else -> throw IllegalArgumentException()
            }

            // 1st part
            totalScore += RpsPlay.calculateScore(yourEnum, theirEnum)
            secondPartScore += RpsPlay.calculateScoreFromDesiredOutcome(theirEnum, desiredOutcome)

            line = this.readLine()
        }
    }

    println("total score: $totalScore")
    println("part 2 total score: $secondPartScore")
}
