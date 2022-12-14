package th.`in`.jamievl.adventofcode.d4

import th.`in`.jamievl.adventofcode.common.readFromResource
import java.lang.IllegalArgumentException
import java.util.regex.Pattern
import kotlin.math.min
import kotlin.math.max

data class AssignmentRange(val start: Int, val end: Int) {
    init {
        if (start > end) {
            throw IllegalArgumentException("Start cannot be less than end!")
        }
    }

    infix fun inside(other: AssignmentRange): Boolean =
        other.start <= start && end <= other.end

    /**
     * Checks if assignment range overlaps with [other].
     *
     * As a note for the implementation,
     * if there is an overlap, say value a such that
     * `start <= a <= end], and `other.start <= a <= other.end`,
     * (for convenience, `ostart` means `other.start` and `oend` means `other.end`)
     * then, ordering `start` and `order.start` (and `end`, `order.end`), we get
     * `min(start,ostart) <= max(start,ostart) <= a <= min(end,oend) <= max(end,oend)`
     *
     * Hence, `max(start, ostart) <= min(end, oend)`.
     *
     * Likewise, if we have `max(start, ostart) <= min(end, oend)`, say there is a value `a` between them, then
     * `start <= max(start, ostart) <= a <= min(end, oend) <= end`
     * the same applies for ostart and oend, hence
     * `ostart <= max(start, ostart) <= a <= min(end, oend) <= oend`
     *
     * Thus, these 2 ranges overlap.
     */
    infix fun overlaps(other: AssignmentRange): Boolean =
        max(start, other.start) <= min(end, other.end)


    companion object {
        private val matchRegex: Pattern = Pattern.compile("""(\d+)-(\d+)""")
        fun fromRangeString(inputString: String): AssignmentRange {
            val match = matchRegex.matcher(inputString.trim())
            match.find()

            val start = match.group(1).toInt()
            val end = match.group(2).toInt()
            return AssignmentRange(start, end)
        }
    }
}

fun main() {
    var insideCount = 0
    var overlapCount = 0
    readFromResource("d4/d4_input.txt") { line ->
        val (assignRange1, assignRange2) = line.split(",").map {
            AssignmentRange.fromRangeString(it)
        }

        if (assignRange1 inside assignRange2 || assignRange2 inside assignRange1) {
            insideCount += 1
        }

        if (assignRange1 overlaps assignRange2) {
            overlapCount += 1
        }
    }

    println("inside count: $insideCount")
    println("overlap count: $overlapCount")
}
