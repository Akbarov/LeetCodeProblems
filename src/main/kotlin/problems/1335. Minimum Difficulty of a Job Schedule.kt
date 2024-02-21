package problems

import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minDifficulty(intArrayOf(6, 5, 4, 3, 2, 1), 2))
}

private fun minDifficulty(jobDifficulty: IntArray, d: Int): Int {
    if (d > jobDifficulty.size) return -1
    val memo = Array(d + 1) { IntArray(jobDifficulty.size) { -1 } }
    return helper(jobDifficulty, memo, d, 0)

}

private fun helper(jobDifficulty: IntArray, memo: Array<IntArray>, days: Int, index: Int): Int {
    if (days == 1) {
        findMax(jobDifficulty, index, jobDifficulty.size)
    }
    var biggest = jobDifficulty[index]
    var minDifficulty = Int.MAX_VALUE
    if (memo[days][index] != -1) return memo[days][index]
    for (i in index..jobDifficulty.size - days) {
        biggest = max(biggest, jobDifficulty[i])
        minDifficulty = min(minDifficulty, helper(jobDifficulty, memo, days - 1, i + 1))
    }
    memo[days][index] = minDifficulty
    return memo[days][index]
}

private fun findMax(jobDifficulty: IntArray, fromIndex: Int, toIndex: Int): Int {
    var result = jobDifficulty[fromIndex]
    for (i in fromIndex until toIndex) {
        result = max(result, jobDifficulty[i])
    }
    return result
}