package problems

import java.util.SortedMap
import kotlin.math.log
import kotlin.math.pow

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(isInterleave("abc", "bcd", "abcbdc"))
    println(isInterleave("aabcc", "dbbca", "aadbbcbcac"))


}


private fun isInterleave(s1: String, s2: String, s3: String): Boolean {

    if (s1.length + s2.length != s3.length) return false
    val dp = Array(s1.length + 1) { BooleanArray(s2.length + 1) }
    for (i in 0..s1.length) {
        for (j in 0..s2.length) {
            if (i == 0 && j == 0) {
                dp[i][j] = true
            } else if (i == 0) {
                dp[i][j] = dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]
            } else if (j == 0) {
                dp[i][j] = dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]
            } else {
                dp[i][j] = (dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]) || dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]
            }
        }
    }
    return dp[s1.length][s2.length]
}
