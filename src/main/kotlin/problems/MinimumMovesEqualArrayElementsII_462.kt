package problems

import kotlin.math.abs

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minMoves3(intArrayOf(1, 2, 3)))
    println(minMoves3(intArrayOf(1, 2, 3, 4, 4, 5, 56, 6, 6, 5, 4, 3)))
}


//O(n^2)
private fun minMoves2(nums: IntArray): Int {

    val set = mutableSetOf<Int>()
    var count = Int.MAX_VALUE
    for (item in nums) {
        if (item in set) continue
        var sum = 0L
        for (newItem in nums) {
            sum += abs(item - newItem)
        }
        set.add(item)
        if (sum < count) count = sum.toInt()
    }
    return count
}

//O(n)
private fun minMoves3(nums: IntArray): Int {
    var count = 0
    var left = 0
    var right = nums.lastIndex
    nums.sort()
    while (left < right) {
        count += nums[right--] - nums[left++]
    }
    return count
}