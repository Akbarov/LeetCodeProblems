package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    println(containsNearbyDuplicate2(intArrayOf(1, 2, 3, 1), 3))
    println(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
    println(containsNearbyDuplicate2(intArrayOf(1, 2, 3, 1, 2, 3), 2))
}

// first solution
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    for ((index, value) in nums.withIndex()) {
        for (i in index + 1..min(k + index, nums.lastIndex)) {
            if (value == nums[i]) return true
        }
    }
    return false
}

// second solution
fun containsNearbyDuplicate2(nums: IntArray, k: Int): Boolean {
    val map = mutableMapOf<Int, Int>()
    for ((index, value) in nums.withIndex()) {
        if (map.containsKey(value) && index - map[value]!! <= k)
            return true
        else {
            map[value] = index
        }
    }
    return false
}
