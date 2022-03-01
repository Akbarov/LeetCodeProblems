package algorithm_II.day_4_two_pointers

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(
        intervalIntersection(
            arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25)),
            arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 23), intArrayOf(24, 24), intArrayOf(25, 25))
        ).forEach { println(it.joinToString()) }
    )
}

private fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {

    if (firstList.isEmpty() || secondList.isEmpty()) return emptyArray()
    var f = 0
    var s = 0
    val result = mutableListOf<IntArray>()
    while (f < firstList.size && s < secondList.size) {
        val low = max(firstList[f][0], secondList[s][0])
        val high = min(firstList[f][1], secondList[s][1])

        if (low <= high) {
            result.add(intArrayOf(low, high))
        }
        if (firstList[f][1] < secondList[s][1]) {
            f++
        } else s++
    }
    return result.toTypedArray()
}