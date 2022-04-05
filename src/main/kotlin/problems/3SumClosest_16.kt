package problems

import kotlin.math.abs

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(threeSumClosest(intArrayOf(-1, 2, 1, -4), 1))
}

private fun threeSumClosest(nums: IntArray, target: Int): Int {
    if (nums.size < 3) return -1
    nums.sort()
    var ans = nums[0] + nums[1] + nums[nums.lastIndex]
    for ((i, item) in nums.withIndex()) {
        var left = i + 1
        var right = nums.lastIndex
        while (left < right) {
            val sum = item + nums[left] + nums[right]
            if (sum > target) right--
            else left++
            if (abs(ans - target) > abs(sum - target)) ans = sum
        }
    }
    return ans
}