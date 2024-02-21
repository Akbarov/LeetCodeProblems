package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    print(carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 4))
    print(carPooling(arrayOf(intArrayOf(2, 1, 5), intArrayOf(3, 3, 7)), 5))
}

private fun carPooling(trips: Array<IntArray>, capacity: Int): Boolean {
    val dp = IntArray(1001)
    var maxCapacity = 0
    for (t in trips) {
        for (i in t[1] until t[2]) {
            dp[i] += t[0]
            maxCapacity = max(maxCapacity, dp[i])
        }
        if (maxCapacity > capacity) return false
    }
    return true

}