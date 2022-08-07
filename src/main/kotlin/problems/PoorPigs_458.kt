package problems

import kotlin.math.ceil
import kotlin.math.log10

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun poorPigs(buckets: Int, minutesToDie: Int, minutesToTest: Int): Int {

    return ceil(log10(buckets.toDouble()) / log10((minutesToTest / minutesToDie + 1).toDouble())).toInt()
}