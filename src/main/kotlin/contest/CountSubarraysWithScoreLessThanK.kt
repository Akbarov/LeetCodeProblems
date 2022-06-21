package contest

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countSubarrays(intArrayOf(2, 1, 4, 3, 5), 10L))
    println(countSubarrays(intArrayOf(1, 1, 1), 5L))
}

private var count = 0L
private fun countSubarrays(nums: IntArray, k: Long): Long {
    count = 0L
    for ((index, item) in nums.withIndex()) {
        helper(nums, k, index, item.toLong(), 1)
    }
    return count
}

private fun helper(nums: IntArray, k: Long, index: Int, product: Long, c: Int) {
    if (product >= k) return
    count++
    if (index >= nums.lastIndex) return
    val temp = (product / c + nums[index + 1]) * (c + 1)
    helper(nums, k, index + 1, temp, c + 1)
}