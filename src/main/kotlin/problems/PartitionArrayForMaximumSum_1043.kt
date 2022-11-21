package problems

import java.lang.Math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maxSumAfterPartitioning(arr: IntArray, k: Int): Int {
        val n = arr.size
        val dp = IntArray(n+1)
        for (i in 1..n) {
                var cur = 0
                var best = 0
                var j =1
                while (j <= k && i - j >= 0) {
                        cur = cur.coerceAtLeast(arr[i - j])
                        best = best.coerceAtLeast(dp[i - j] + cur * j)
                        j++
                }
                dp[i] = best
        }
        return dp[n]
}