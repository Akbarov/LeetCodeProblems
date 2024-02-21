package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun longestAlternatingSubarray(nums: IntArray, threshold: Int): Int {
    var result = 0
    var slow = Int.MAX_VALUE
    var fast = 0
    while (fast < nums.size) {
        if (nums[fast] > threshold || (fast > 0 && nums[fast] % 2 == nums[fast - 1] % 2)) {
            result = max(result, fast - slow)
            slow = fast
        }
        if (slow == Int.MAX_VALUE && nums[fast] <= threshold && nums[fast] % 2 == 0) slow = fast
        fast++
    }
    result = max(result, fast - slow)
    return result
}