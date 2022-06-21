package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(deleteAndEarn(intArrayOf(2, 2, 3, 3, 3, 4)))
}

private fun deleteAndEarn(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (n in nums) {
        map[n] = (map[n] ?: 0) + n
    }
    var oneBack = map[nums[0]] ?: 0
    val set = map.keys.sorted()
    var twoBack = 0
    for (i in 1 until set.size) {
        val current = set[i]
        val temp = oneBack
        if (current == set[i - 1] + 1) {
            oneBack = max(oneBack, twoBack + (map[current] ?: 0))
        } else {
            oneBack += (map[current] ?: 0)
        }
        twoBack = temp
    }
    return oneBack
}