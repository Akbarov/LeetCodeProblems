package binary_search_I.day_2

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(searchInsert(intArrayOf(1, 3, 5, 6), 2))
}

private fun searchInsert(nums: IntArray, target: Int, left: Int = 0, right: Int = nums.lastIndex): Int {
    if (nums.last() < target) return nums.size
    val mid = (left + right) / 2
    if (left > right) return left
    return if (nums[mid] == target) mid
    else if (nums[mid] < target) searchInsert(nums, target, mid + 1, right)
    else searchInsert(nums, target, left, mid - 1)

}

private fun searchIteration(nums: IntArray, target: Int): Int {
    for ((index, item) in nums.withIndex()) {
        if (item >= target) return index
    }
    return -1
}