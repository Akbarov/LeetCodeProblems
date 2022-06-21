package problems

import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(maxSubArraySumCircular(intArrayOf(1, -2, 3, -2)))
    println(maxSubArraySumCircular(intArrayOf(5, -3, 5)))
}

private fun maxSubArraySumCircular(nums: IntArray): Int {
    val maxSum = maxSum(nums)
    val minSum = minSum(nums)
    return max(maxSum, nums.sum() - minSum)
}

private fun maxSum(nums: IntArray): Int {
    var result = nums[0]
    var sum = 0
    for (item in nums) {
        sum += item
        result = max(result, sum)
        if (sum < 0) sum = 0
    }
    return result
}

private fun minSum(nums: IntArray): Int {
    var result = nums[0]
    var sum = 0
    for (item in nums) {
        sum += item
        result = min(result, sum)
        if (sum > 0) sum = 0
    }
    return result
}