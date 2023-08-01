package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun countSubIslands(grid1: Array<IntArray>, grid2: Array<IntArray>): Int {
    var count = 0
    for (i in grid2.indices) {
        for (j in grid2[0].indices) {
            if (grid2[i][j] == 1 && grid1[i][j] == 1) {
                count += dfs(grid1, grid2, i, j)
            }
        }
    }
    return count
}

private fun dfs(grid1: Array<IntArray>, grid2: Array<IntArray>, i: Int, j: Int): Int {
    if (i < 0 || i >= grid2.size || j < 0 || j >= grid2[0].size || grid2[i][j] == 0) return 1
    grid2[i][j] = 0
    val dirX = intArrayOf(0, 1, 0, -1)
    val dirY = intArrayOf(-1, 0, 1, 0)
    var isCovered = 1
    for (k in dirX.indices) {
        val row = i + dirX[k]
        val col = j + dirY[k]
        isCovered = isCovered and dfs(grid1, grid2, row, col)
    }
    return isCovered
}
