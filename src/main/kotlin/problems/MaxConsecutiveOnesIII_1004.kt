package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun longestOnes(nums: IntArray, k: Int): Int {
    var left = 0
    var right = 0
    var zeros = 0
    var result = 0
    while (right < nums.size) {
        if (nums[right] == 0) {
            if (++zeros > k) {
                while (left <= right && zeros > k) {
                    if (nums[left++] == 0) {
                        zeros--
                    }
                }
            }
        }
        result = max(result, right - left + 1)
        right++
    }
    return result
}