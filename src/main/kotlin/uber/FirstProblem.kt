package uber

import kotlin.math.max


fun main() {

}

private var result = 0
private fun rob(nums: IntArray): Int {
    if (nums.size == 1) return nums.first()
    if (nums.size == 2) return max(nums.first(), nums.last())
    val dp = IntArray(nums.size)
    dp[0] = nums[0]
    dp[1] = nums[1]
    var index = 2
    while (index < nums.size) {
        dp[index] = getMaxUntil(dp, index - 1)
        index++
    }
    return getMaxUntil(dp, dp.size)
}

private fun getMaxUntil(dp: IntArray, index: Int): Int {
    var result = 0
    for (i in 0 until index) {
        result = max(result, dp[i])
    }
    return result
}

