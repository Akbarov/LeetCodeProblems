package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findMinArrowShots(arrayOf(
        intArrayOf(-2147483646,-2147483645),
        intArrayOf(2147483646,2147483647),
    )))
}

private fun findMinArrowShots(points: Array<IntArray>): Int {
    points.sortWith(Comparator { o1, o2 -> o1[0].compareTo(o2[0]) })
    var i = 1
    var result = 1
    val last = intArrayOf(points[0][0], points[0][1])
    while (i < points.size ) {
        if (last[1] >= points[i][0]) {
            last[1] = min(last[1], points[i][1])
        } else {
            result++
            last[0] = points[i][0]
            last[1] = points[i][1]
        }
        i++
    }
    return result
}