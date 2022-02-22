package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(removeCoveredIntervals(arrayOf(intArrayOf(1, 3), intArrayOf(2, 5), intArrayOf(3, 4))))
}

private fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
    intervals.sortBy { it.first() }
    var maxLeft = Int.MIN_VALUE
    var maxRight = Int.MIN_VALUE
    var count = 0
    for (array in intervals) {
        if (array.first() > maxLeft && array.last() > maxRight) {
            count++
            maxLeft = array.first()
        }
        maxRight = max(maxRight, array.last())
    }
    return count
}