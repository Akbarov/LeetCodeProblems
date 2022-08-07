package problems

import kotlin.math.abs
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minAreaRect(points: Array<IntArray>): Int {
    val xMap = mutableMapOf<Int, MutableSet<Int>>()
    var minArea = Int.MAX_VALUE
    for (point in points) {
        if (point[0] in xMap) {
            xMap[point[0]]?.add(point[1])
        } else {
            xMap[point[0]] = mutableSetOf(point[1])
        }
    }
    for (i in points.indices) {
        for (j in i + 1 until points.size) {
            val x1 = points[i][0]
            val y1 = points[i][1]
            val x2 = points[j][0]
            val y2 = points[j][1]
            if (x1 != x2 && y1 != y2) {
                if (xMap[x1]?.contains(y2) == true && xMap[x2]?.contains(y1) == true) {
                    minArea = min(minArea, abs(x1-x2)* abs(y1-y2))
                }
            }
        }
    }

    return minArea
}