package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun distributeCandies(candyType: IntArray): Int {
    return min(candyType.size / 2, candyType.toSet().size)
}
