package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(
        minOperations2(
            intArrayOf(5, 2, 3, 1, 1), 5
        )
    )
    println(
        minOperations2(
            intArrayOf(3, 2, 20, 1, 1, 3), 10
        )
    )
    println(
        minOperations2(
            intArrayOf(5, 6, 7, 8), 10
        )
    )
}

private var minCount = Int.MAX_VALUE
private fun minOperations(nums: IntArray, x: Int): Int {
    minCount = Int.MAX_VALUE
    helper(nums, x, 0, nums.lastIndex)
    return if (minCount == Int.MAX_VALUE) -1 else minCount
}

private fun helper(nums: IntArray, x: Int, left: Int, right: Int) {
    if (right < left || x < 0) return
    if (right == left) {
        if (x - nums[left] == 0 && minCount > nums.size) {
            minCount = nums.size
        }
    }
    if (x == 0) {
        val count = nums.lastIndex - right + left
        if (minCount > count) {
            minCount = count
        }
    }
    helper(nums, x - nums[left], left + 1, right)
    helper(nums, x - nums[right], left, right - 1)
}

private fun minOperations2(nums: IntArray, x: Int): Int {
    var length = -1
    val sum = nums.sum() - x
    var right = 0
    var left = 0
    var currentSum = 0
    while (right < nums.size) {
        currentSum += nums[right]
        while (left <= right && currentSum > sum) {
            currentSum -= nums[left]
            left++
        }
        if (currentSum == sum) {
            length = max(length, right - left+1)
        }
        right++
    }
    return if (length==-1) -1 else nums.size-length
}