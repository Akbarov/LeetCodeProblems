package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestSubsequence(intArrayOf(1, 2, 3, 4), 1))
}

private fun longestSubsequence(arr: IntArray, difference: Int): Int {
    val map = mutableMapOf<Int, Int>()
    var result = 1
    for (item in arr) {
        map[item] = 1
    }
    for (item in arr) {
        if ((item - difference) in map) {
            val prev = map[item - difference] ?: 1
            map[item] = max(prev + 1, map[item] ?: 1)
            result = max(result, map[item] ?: 1)
        }
    }
    return result
}
