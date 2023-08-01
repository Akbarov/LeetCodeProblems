package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minDistance(word1: String, word2: String): Int {
    if (word1.isEmpty()) return word2.length
    if (word2.isEmpty()) return word1.length
    val dp = Array(word1.length) { IntArray(word2.length) { -1 } }
    return helper(word1, word2, 0, 0, dp)

}

private fun helper(word1: String, word2: String, i: Int, j: Int, dp: Array<IntArray>): Int {
    if (word1.length == i) {
        return word2.length - j
    }
    if (word2.length == j) {
        return word1.length - i
    }
    if (dp[i][j] != -1) return dp[i][j]
    dp[i][j] = if (word1[i] == word2[j]) {
        helper(word1, word2, i + 1, j + 1, dp)
    } else {
        val insert = helper(word1, word2, i, j + 1, dp)
        val delete = helper(word1, word2, i + 1, j, dp)
        val replace = helper(word1, word2, i + 1, j + 1, dp)
        min(insert, min(delete, replace))
    }
    return dp[i][j]
}