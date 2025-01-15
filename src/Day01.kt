import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val (left, right) = input.map { inputPair ->
            val first = inputPair.substringBefore(" ").toInt()
            val second = inputPair.substringAfterLast(" ").toInt()
            first to second
        }.unzip()

        val result = left.sorted().zip(right.sorted()).map { (first,second) ->
            abs(first - second)
        }.sum()

        return result
    }

    fun part2(input: List<String>): Long {
        val (left, right) = input.map { inputPair ->
            inputPair.split(Regex("\\s+")).let {
                it[0].toLong() to it[1].toLong()
            }
        }.unzip()

        val frequency = right.groupingBy { it }.eachCount()

        val result = left.fold(0L){ acc, num ->
            acc + num * frequency.getOrDefault(num ,0)
        }

        return result
    }


    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
