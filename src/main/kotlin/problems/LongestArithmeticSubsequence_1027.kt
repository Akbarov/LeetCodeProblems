package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}


private fun longestArithSeqLength(nums: IntArray): Int {
    var longest = 0
    val dp = Array(nums.size) { mutableMapOf<Int, Int>() }
    for (i in 1 until nums.size) {
        for (j in 0 until i) {
            val dif = nums[i] - nums[j]
            val len = dp[j][dif] ?: 2
            val cur = dp[i][dif] ?: 0
            dp[i][dif] = max(len, cur)
            longest = max(longest, dp[i][dif] ?: 0)
        }
    }
    return longest
}
