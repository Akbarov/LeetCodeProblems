package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private var result = 0
private fun uniquePathsIII(grid: Array<IntArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0
    val visited = Array(grid.size) { BooleanArray(grid[0].size) }
    for (i in grid.indices) {
        for (j in 0 until grid[i].size) {
            if (grid[i][j] == -1) visited[i][j] = true
        }
    }
    for (i in grid.indices) {
        for (j in 0 until grid[i].size) {
            if (grid[i][j] == 1) {
                dfs(grid, i, j, visited)
            }
        }
    }

    return result
}

private fun dfs(grid: Array<IntArray>, i: Int, j: Int, visited: Array<BooleanArray>) {
    if (i < 0 || i >= grid.size || j < 0 || j >= grid[i].size || visited[i][j]) {
        return
    }
    if (grid[i][j] == 2 && allVisited(visited)) {
        result++
        return
    }
    visited[i][j] = true
    dfs(grid, i, j - 1, visited)
    dfs(grid, i, j + 1, visited)
    dfs(grid, i - 1, j, visited)
    dfs(grid, i + 1, j, visited)
}

private fun allVisited(visited: Array<BooleanArray>): Boolean {
    visited.forEach { array ->
        array.forEach {
            if (!it) return false
        }
    }
    return true
}