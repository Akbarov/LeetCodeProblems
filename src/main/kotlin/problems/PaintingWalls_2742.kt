package problems

import java.util.*


/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(paintWalls(intArrayOf(8, 7, 5, 15), intArrayOf(1, 1, 2, 1)))
    print(paintWalls(intArrayOf(26, 53, 10, 24, 25, 20, 63, 51), intArrayOf(1, 1, 1, 1, 2, 2, 2, 1)))
}

private fun paintWalls(cost: IntArray, time: IntArray): Int {
    val n: Int = cost.size
    val dp = IntArray(n + 1)
    Arrays.fill(dp, 1e9.toInt())
    dp[0] = 0
    for (i in 0 until n) for (j in n downTo 1) dp[j] =
        dp[j].coerceAtMost(
            dp[(j - time[i] - 1)
                .coerceAtLeast(0)] + cost[i]
        )
    return dp[n]
}