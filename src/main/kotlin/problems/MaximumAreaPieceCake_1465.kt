package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxArea(5, 4, intArrayOf(1, 2, 4), intArrayOf(1, 3)))
    println(maxArea(5, 4, intArrayOf(3, 1), intArrayOf(1)))
    println(maxArea(5, 4, intArrayOf(3), intArrayOf(3)))
}

private fun maxArea(h: Int, w: Int, horizontalCuts: IntArray, verticalCuts: IntArray): Int {
    val module = 1_000_000_000 + 7
    horizontalCuts.sort()
    verticalCuts.sort()
    var maxH = max(horizontalCuts[0], h - horizontalCuts[horizontalCuts.size - 1])
    var maxV = max(verticalCuts[0], w - verticalCuts[verticalCuts.size - 1])

    for (i in 0 until horizontalCuts.lastIndex) {
        maxH = max(maxH, horizontalCuts[i + 1] - horizontalCuts[i])
    }
    for (i in 0 until verticalCuts.lastIndex) {
        maxV = max(maxV, verticalCuts[i + 1] - verticalCuts[i])
    }

    return ((1L*maxV*maxH) % module).toInt()

}