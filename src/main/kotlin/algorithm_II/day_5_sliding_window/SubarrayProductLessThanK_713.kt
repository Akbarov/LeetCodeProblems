package algorithm_II.day_5_sliding_window

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(numSubarrayProductLessThanK(intArrayOf(10,5,2,6),100))
println(numSubarrayProductLessThanK(intArrayOf(1,2,3),2))
}

private fun numSubarrayProductLessThanK(nums: IntArray, k: Int): Int {

    var left = 0
    var product = 1
    var counter = 0

    for ((index, value) in nums.withIndex()) {
        product *= value
        while (product >= k&&left<=index) {
            product /= nums[left++]
        }
        counter += (index - left + 1)
    }
    return counter

}