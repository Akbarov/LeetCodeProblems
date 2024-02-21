package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var result = 1
private fun integerBreak(n: Int): Int {
    val dp = IntArray(n + 1)
    if (n <= 0) return 0
    dp[0] = 0
    dp[1] = 1
    for (i in 2..n) {
        for (j in 1 until i) {
            dp[i] = max(dp[i], max(j, dp[j]) * max(i - j, dp[i - j]))
        }
    }
    return dp[n]

}
