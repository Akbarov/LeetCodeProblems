package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(findPaths2(2, 2, 2, 0, 0))
    println(findPaths2(1, 3, 3, 0, 1))

}

private val MODE = 1_000_000_000 + 7
private var totalMoves = 0

// recursion
private fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
    totalMoves = 0
    helper(m, n, maxMove, startRow, startColumn, 0)
    return totalMoves
}

private fun helper(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int, currentMoves: Int) {
    if (currentMoves > maxMove) return
    if (startRow < 0 || startRow >= m || startColumn < 0 || startColumn >= n) {
        totalMoves = (totalMoves + 1) % MODE
        return
    }
    helper(m, n, maxMove, startRow - 1, startColumn, currentMoves + 1)
    helper(m, n, maxMove, startRow + 1, startColumn, currentMoves + 1)
    helper(m, n, maxMove, startRow, startColumn - 1, currentMoves + 1)
    helper(m, n, maxMove, startRow, startColumn + 1, currentMoves + 1)
}

// dp
private fun findPaths2(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
    var count = 0
    var dp = Array(m) { IntArray(n) }
    dp[startRow][startColumn] = 1
    for (k in 0 until maxMove) {
        val tempDp = Array(m) { IntArray(n) }
        for (i in 0 until m) {
            for (j in 0 until n) {
                if (j == 0) count = (count + dp[i][j]) % MODE
                if (j == n - 1) count = (count + dp[i][j]) % MODE
                if (i == 0) count = (count + dp[i][j]) % MODE
                if (i == m - 1) count = (count + dp[i][j]) % MODE
                tempDp[i][j] = (((if (i > 0) dp[i - 1][j] else 0) + (if (i < m - 1) dp[i + 1][j] else 0)) % MODE +
                        ((if (j > 0) dp[i][j - 1] else 0) + (if (j < n - 1) dp[i][j + 1] else 0)) % MODE) % MODE
            }
        }
        dp = tempDp
    }
    return count
}

