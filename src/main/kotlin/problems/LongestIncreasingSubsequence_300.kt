package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
}

private fun lengthOfLIS2(nums: IntArray): Int {
    var ans = 1
    val dp = IntArray(nums.size) { 1 }
    for (i in nums.indices) {
        for (j in 0 until i) {
            if (nums[i] > nums[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
                ans = max(ans, dp[i])
            }
        }
    }
    return ans
}

private var lis = 1
private fun lengthOfLIS(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    val dp = IntArray(nums.size) { 1 }
    lis = 1
    nums.forEachIndexed { index, _ ->
        helper(nums, index, 1)
    }
    return lis
}

private fun helper(nums: IntArray, index: Int, count: Int) {
    if (index >= nums.size) return
    if (lis < count) lis = count
    for (i in index + 1 until nums.size) {
        if (nums[index] < nums[i]) {
            helper(nums, i, count + 1)
        }
    }
}