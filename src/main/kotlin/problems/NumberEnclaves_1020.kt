package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun numEnclaves(grid: Array<IntArray>): Int {
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if ((i == 0 || i == grid.size - 1 || j == 0 || j == grid[0].size - 1) && grid[i][j] == 1) {
                makeZero(grid, i, j)
            }
        }
    }
    var result = 0
    for (row in grid) {
        result += row.count { it == 1 }
    }
    return result
}

private fun makeZero(grid: Array<IntArray>, i: Int, j: Int) {
    if (i < 0 || i >= grid.size || j < 0 || j >= grid[0].size || grid[i][j] == 0) return
    grid[i][j] = 0
    val dirX = intArrayOf(0, 1, 0, -1)
    val dirY = intArrayOf(-1, 0, 1, 0)
    for (k in dirX.indices) {
        val row = i + dirX[k]
        val col = j + dirY[k]
        makeZero(grid, row, col)
    }
}