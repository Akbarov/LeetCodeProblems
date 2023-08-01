package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun knightProbability(n: Int, k: Int, row: Int, column: Int): Double {
    var probability = 0.0
    val dp = Array(k) { Array(n) { DoubleArray(n) } }
    val directions = arrayOf(
        intArrayOf(1, 2), intArrayOf(1, -2), intArrayOf(2, 1), intArrayOf(2, -1),
        intArrayOf(-1, 2), intArrayOf(-1, -2), intArrayOf(-2, 1), intArrayOf(-2, -1)
    )
    dp[0][row][column] = 1.0
    for (moves in 1 until k) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                for (dir in directions) {
                    val prevI = i - dir[0]
                    val prefJ = j - dir[1]
                    if (prevI in 0 until n && prefJ in 0 until n) {
                        dp[moves][i][j] += (dp[moves - 1][prevI][prefJ] / 8)
                    }
                }
            }
        }
    }
    for (i in 0 until n) {
        for (j in 0 until n) {
            probability += dp[k][i][j]
        }
    }

    return probability
}