package problems

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(maxSubarrayLength(intArrayOf(2, 2, 3), 1))
}

private fun maxSubarrayLength(nums: IntArray, k: Int): Int {
    var result = 0
    val map = mutableMapOf<Int, Int>()
    var maxCount = 0
    var slow = 0
    var fast = 0
    while (fast < nums.size) {
        map[nums[fast]] = (map[nums[fast]] ?: 0) + 1
        maxCount = max(maxCount, map[nums[fast]] ?: 0)
        while (maxCount > k && slow <= fast) {
            map[nums[slow]] = (map[nums[slow]] ?: 0) - 1
            maxCount = min(maxCount, map[nums[fast]] ?: 0)
            slow++
        }
        fast++
        result = max(result, fast - slow)
    }
    return result
}