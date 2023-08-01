package problems

import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(closestMeetingNode(intArrayOf(4, 3, 0, 5, 3, -1), 4, 0))
    println(closestMeetingNode(intArrayOf(1, 2, -1), 0, 2))
}

private fun closestMeetingNode(edges: IntArray, node1: Int, node2: Int): Int {
    val dp = IntArray(edges.size) { -1 }
    val dp2 = IntArray(edges.size) { -1 }

    var count = 0
    var result = edges.size
    var i = node1
    while (i >= 0 && dp[i] == -1) {
        dp[i] = count++
        i = edges[i]
    }
    i = node2
    count = 0
    var res = -1
    var minValue = Int.MAX_VALUE
    while (i != -1 && dp2[i] == -1) {
        dp2[i] = count++
        if (dp[i] >= 0 && max(dp[i], dp2[i]) <= minValue) {
            res = if (max(dp[i], dp2[i]) == minValue) min(res, i) else i
            minValue = max(dp[i], dp2[i])
        }
        i=edges[i]
    }
    return res
}