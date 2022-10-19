package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(maxProfit(intArrayOf(1,2,3,0,2)))
}

private var maxProfit = 0
private fun maxProfit(prices: IntArray): Int {
    helper(prices, 0, 0, true)
    return maxProfit
}

private fun helper(prices: IntArray, index: Int, currentProfit: Int, shouldBuy: Boolean) {
    if (currentProfit > maxProfit) maxProfit = currentProfit
    if (index >= prices.size) return
    if (shouldBuy) {
        for (i in index until prices.size) {
            helper(prices, i, currentProfit, false)
        }
    } else {
        for (i in index + 1 until prices.size) {
            helper(prices, i + 2, currentProfit + prices[i] - prices[index], true)
        }
    }
}