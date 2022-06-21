package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    println(maxProfit2(intArrayOf(7, 1, 5, 3, 6, 4)))
}

private fun maxProfit(prices: IntArray): Int {
    var prof = 0
    for (i in 1 until prices.size) {
        prof += max(prices[i] - prices[i - 1], 0)
    }
    return prof
}

private fun maxProfit2(prices: IntArray): Int {
    var prof = 0
    var i = 0
    while (i < prices.size) {
        while (i < prices.size - 1 && prices[i] >= prices[i + 1]) i++
        val minValue = prices[i++]
        while (i < prices.size - 1 && prices[i] <= prices[i + 1]) i++
        prof += if (i < prices.size) prices[i++] - minValue else 0
    }
    return prof
}