package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun countPalindromicSubsequence(s: String): Int {
    val firstAppear = IntArray(26) { Int.MAX_VALUE }
    val lastAppear = IntArray(26)
    for ((i, c) in s.withIndex()) {
        firstAppear[c - 'a'] = min(firstAppear[c - 'a'], i)
        lastAppear[c - 'a'] = i
    }
    var result = 0
    for (i in 0 until 26) {
        if (firstAppear[i] < lastAppear[i]) {
            result += s.substring(firstAppear[i] + 1, lastAppear[i]).toSet().size
        }
    }
    return result
}