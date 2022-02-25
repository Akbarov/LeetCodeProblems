package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))
}

private fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0
    var buy = Int.MAX_VALUE
    for (item in prices) {
        if (item < buy) {
            buy = item
        }
        if (item - buy > maxProfit) {
            maxProfit = item - buy
        }
    }
    return maxProfit
}