package problems

import kotlin.math.abs

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findDisappearedNumbers(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)))
}

//O(n) space
private fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val bools = BooleanArray(nums.size)
    for (n in nums) {
        bools[n - 1] = true
    }
    val list = mutableListOf<Int>()
    for (i in bools.indices) {
        if (!bools[i]) {
            list.add(i + 1)
        }
    }
    return list
}

//O(1) space
private fun findDisappearedNumbers2(nums: IntArray): List<Int> {
    for (i in nums.indices) {
        val temp = abs(nums[i]) - 1
        if (nums[temp] > 0) nums[temp] = -nums[temp]
    }
    val list = mutableListOf<Int>()
    for (i in nums.indices) {
        if (nums[i] > 0) {
            list.add(i + 1)
        }
    }
    return list
}