package problems

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
    val memo = Array<IntArray>(nums1.size + 1) { IntArray(nums2.size + 1) { -1 } }
    return solve(nums1, nums2, memo, nums1.size, nums2.size)
}

private fun solve(nums1: IntArray, nums2: IntArray, memo: Array<IntArray>, i: Int, j: Int): Int {
    if (i <= 0 || j <= 0) return 0
    if (memo[i][j] != -1) return memo[i][j]
    if (nums1[i - 1] == nums2[j - 1]) {
        memo[i][j] = 1 + solve(nums1, nums2, memo, i - 1, j - 1)
    } else {
        memo[i][j] = max(solve(nums1, nums2, memo, i - 1, j), solve(nums1, nums2, memo, i, j - 1))
    }
    return memo[i][j]
}