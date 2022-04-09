package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(findKthLargest(intArrayOf(1, 2, 3, 4, 2, 3, 5), 3))

}

private fun findKthLargest(nums: IntArray, k: Int): Int {

    if (nums.size <= k || k < 1) return -1
    nums.sortDescending()
    return nums[k - 1]
}