package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(jobScheduling(intArrayOf(1, 2, 3, 3), intArrayOf(3, 4, 5, 6), intArrayOf(50, 10, 40, 70)))
}


private fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val profitArray = Array(startTime.size) { i -> Profit(startTime[i], endTime[i], profit[i]) }
    profitArray.sortWith(Comparator { o1, o2 -> o1.end.compareTo(o2.end) })
    return helper(profitArray)

}

private fun helper(profitArray: Array<Profit>): Int {
    val n = profitArray.size
    val dp = IntArray(n)
    dp[0] = profitArray[0].profit
    for (i in 1 until n) {
        var profit = profitArray[i].profit
        val index = searchProfit(profitArray, i)
        if (index != -1) {
            profit += dp[index]
        }
        dp[i] = Math.max(dp[i - 1], profit)
    }
    return dp[n - 1]
}

private fun searchProfit(profitArray: Array<Profit>, index: Int): Int {
    var start = 0
    var end = index - 1
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (profitArray[mid].end <= profitArray[index].start) {
            if (profitArray[mid + 1].end <= profitArray[index].start) {
                start = mid + 1
            } else {
                return mid
            }
        } else {
            end = mid - 1
        }
    }
    return -1
}

private data class Profit(val start: Int, val end: Int, val profit: Int)