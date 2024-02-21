package problems

import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun predictTheWinner(nums: IntArray): Boolean {
    val total = nums.sum()
    val memo = Array(nums.size) { IntArray(nums.size) { -1 } }
    val firstMax = getFirstMaxScore(nums, 0, nums.lastIndex, memo)
    return firstMax >= total - firstMax
}

private fun getFirstMaxScore(nums: IntArray, left: Int, right: Int, memo: Array<IntArray>): Int {
    if (left > right) return 0
    if (left == right) return nums[left]
    if (memo[left][right] != -1) return memo[left][right]
    val current = max(
        nums[left] + min(
            getFirstMaxScore(nums, left + 2, right, memo),
            getFirstMaxScore(nums, left + 1, right - 1, memo)
        ),
        nums[right] + min(
            getFirstMaxScore(nums, left, right - 2, memo),
            getFirstMaxScore(nums, left + 1, right - 1, memo)
        )
    )
    memo[left][right] = current
    return current
}