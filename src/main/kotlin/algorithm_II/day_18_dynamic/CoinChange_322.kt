package algorithm_II.day_18_dynamic

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(coinChange(intArrayOf(1, 2, 5), 100))
}

private fun coinChange(coins: IntArray, amount: Int): Int {
    if (amount == 0) return 0
    val dp = IntArray(amount + 1) { amount + 1 }
    dp[0] = 0
    for (i in 1..amount) {
        for (element in coins) {
            if (i-element>=0)
            dp[i] = min(dp[i], 1 + dp[i - element])
        }
    }
    return if (dp[amount]==amount+1) -1 else dp[amount]
}
