package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maximalNetworkRank(n: Int, roads: Array<IntArray>): Int {
    val dp = Array<MutableSet<Int>>(n + 1) { mutableSetOf() }
    for (r in roads) {
        dp[r[0]].add(r[1])
        dp[r[1]].add(r[0])
    }
    var result = 0
    for (i in 1..n) {
        for (j in i + 1..n) {
            val connection = if (j in dp[i]) {
                dp[i].size + dp[j].size - 1
            } else {
                dp[i].size + dp[j].size
            }
            result = max(result,connection)
        }
    }
    return result
}