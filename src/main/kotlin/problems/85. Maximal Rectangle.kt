package problems

import kotlin.math.max
import kotlin.math.min

fun main() {


}

private fun maximalRectangle(matrix: Array<CharArray>): Int {
    val dp = Array(matrix.size) { IntArray(matrix[0].size) }
    var result = 0

    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == '1') {
                var count = 1
                for (k in j until matrix[i].size) {
                    if (matrix[i][k] == '1') count++
                }
            }
        }
    }

    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == '1') {
                var length = dp[i][j]
                for (k in i until matrix.size) {
                    length = min(length, dp[k][k])
                    result = max(length * (k - i + 1), result)
                }

            }
        }
    }

    return result
}
