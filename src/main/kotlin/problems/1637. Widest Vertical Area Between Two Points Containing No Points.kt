package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maxWidthOfVerticalArea(points: Array<IntArray>): Int {

    points.sortBy { it.first() }
    var left = points[0].first()
    var result = 0
    for (right in points) {
        result = max(result, right.first() - left)
        left = right.first()
    }
    return result
}