package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun orangesRotting(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0
    val m = grid.size
    val n = grid[0].size
    val dp = Array(m) { IntArray(n) { m + n } }
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (grid[i][j] == 2) {
                dfs(grid, i, j, dp, 0)
            }
        }
    }
    var result = 0
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (dp[i][j] > result) {
                result = dp[i][j]
            }
        }
    }
    return result
}

private fun dfs(grid: Array<IntArray>, i: Int, j: Int, dp: Array<IntArray>, count: Int) {
    if (i < 0 || i >= grid.size || j < 0 || j >= grid[i].size || grid[i][j] == 0 || count >= dp[i][j]) return
    dp[i][j] = count
    dfs(grid, i, j - 1, dp, count + 1)
    dfs(grid, i, j + 1, dp, count + 1)
    dfs(grid, i - 1, j, dp, count + 1)
    dfs(grid, i + 1, j, dp, count + 1)

}