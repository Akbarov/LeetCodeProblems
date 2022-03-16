package algorithm_II.day_17_dynamic_programming

import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(minDistance("leetcode", "etco"))
    println(minDistance("tea", "sea"))
}

private fun minDistance(word1: String, word2: String): Int {
    return word1.length + word2.length - longestCommonSubsequence(word1, word2) * 2

}

private fun longestCommonSubsequence(text1: String, text2: String): Int {
    if (text1.isEmpty() || text2.isEmpty()) return 0
    val array = Array(text1.length + 1) { IntArray(text2.length + 1) }
    for (i in 1 until array.size) {
        for (j in 1 until array[i].size) {
            if (text1[i - 1] == text2[j - 1]) {
                array[i][j] = array[i - 1][j - 1] + 1
            } else {
                array[i][j] = max(array[i - 1][j], array[i][j - 1])
            }
        }
    }
    return array[text1.length][text2.length]

}