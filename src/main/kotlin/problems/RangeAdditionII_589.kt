package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxCount(3, 3, arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 1), intArrayOf(1, 1, 1))))
}

private fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
    if (ops.isEmpty()) return m * n
    var xMin = m
    var yMin = n
    for (ar in ops) {
        xMin = min(xMin, ar[0])
        yMin = min(yMin, ar[1])
    }
    return xMin * yMin
}