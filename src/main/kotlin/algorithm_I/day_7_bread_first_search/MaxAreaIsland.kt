package algorithm_I.day_7_bread_first_search

import kotlin.math.max

fun main() {
    val area = maxAreaOfIsland(
        arrayOf(
            intArrayOf(0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0),
            intArrayOf(0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0),
        )
    )
    println(area)
}

private fun maxAreaOfIsland(grid: Array<IntArray>): Int {
    var maxArea = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (grid[i][j] == 1) {
                maxArea = max(maxArea, find(grid, i, j))
            }
        }
    }
    for (array in grid) {
        println(array.joinToString())
    }
    return maxArea
}

private fun find(grid: Array<IntArray>, r: Int, c: Int): Int {
    if (r < 0 || c < 0 || r >= grid.size || c >= grid[0].size || grid[r][c] == 0) {
        return 0
    }
    grid[r][c] = 0
    return 1 + find(grid, r - 1, c) + find(grid, r + 1, c) + find(grid, r, c - 1) + find(grid, r, c + 1)
}
