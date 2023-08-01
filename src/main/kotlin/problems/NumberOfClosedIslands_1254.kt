package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
}

private fun closedIsland(grid: Array<IntArray>): Int {
    var result = 0
    val visited = Array(grid.size) { BooleanArray(grid[0].size) { false } }
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 0 && !visited[i][j] && isClosed(visited, grid, i, j)) {
                result++
            }
        }
    }
    return result
}

fun isClosed(visted: Array<BooleanArray>, grid: Array<IntArray>, i: Int, j: Int): Boolean {
    if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size) return false
    if (grid[i][j] == 1 || visted[i][j]) return true
    visted[i][j] = true
    val dirX = intArrayOf(0, 1, 0, -1)
    val dirY = intArrayOf(-1, 0, 1, 0)
    var closed = true
    for (k in dirX.indices) {
        val row = i+dirX[k]
        val col = i+dirY[k]
        if (!isClosed(visted, grid, row, col)) {
            closed=false
        }
    }
    return closed
}
