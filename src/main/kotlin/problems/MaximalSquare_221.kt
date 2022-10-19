package problems

import kotlin.math.max
import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun maximalSquare(matrix: Array<CharArray>): Int {
    val dp = Array(matrix.size + 1) { IntArray(matrix[0].size + 1) }
    var m = 0
    for (i in 1 until dp.size) {
        for (j in 1 until matrix[0].size) {
            if (matrix[i][j] == '1') {
                dp[i][j] = min(min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1])
                m = max(m, dp[i][j])
            }
        }
    }
    return m*m
}