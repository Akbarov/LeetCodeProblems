package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(maxProfit(intArrayOf(1,3,2,8,4,9),2))
}

private fun maxProfit(prices: IntArray, fee: Int): Int {

    val n = prices.size
    var buy = 0
    var sell = 0
    buy = -prices[0]
    for (i in 1 until n) {
        val temp = buy
        buy = max(buy, sell - prices[i])
        sell = max(sell, temp + prices[i]-fee)
    }
    return sell

}