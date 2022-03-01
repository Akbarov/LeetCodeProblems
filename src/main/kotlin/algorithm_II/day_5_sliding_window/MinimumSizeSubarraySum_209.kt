package algorithm_II.day_5_sliding_window

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    println(minSubArrayLen(4, intArrayOf(1, 4, 4)))
    println(minSubArrayLen(11, intArrayOf(1, 2,3,4,5)))
    println(minSubArrayLen(15, intArrayOf(1, 2,3,4,5)))
}

private fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var product = 0
    var left = 0
    var count = Int.MAX_VALUE
    for ((index, value) in nums.withIndex()) {
        product += value
        while (product >= target && left <= index) {
            if (count > index - left) {
                count = index - left + 1
            }
            if (count == 1) {
                return 1
            }
            product -= nums[left++]
        }
    }
    return if (count == Int.MAX_VALUE) 0 else count
}