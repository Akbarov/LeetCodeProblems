package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    var matrix = arrayOf(
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 1),
        intArrayOf(4, 2, 1),
    )
    println(minPathSum3(matrix))
    matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
    )
    println(minPathSum3(matrix))
}


private var resultNumber = Int.MAX_VALUE
private fun minPathSum(grid: Array<IntArray>): Int {
    resultNumber = Int.MAX_VALUE
    helper(grid, 0, 0, 0)
    return resultNumber
}

private fun helper(grid: Array<IntArray>, row: Int, column: Int, sum: Int) {

    if (row >= grid.size || column >= grid[0].size) return
    if (row == grid.lastIndex && column == grid[0].lastIndex) {
        if (sum + grid[row][column] < resultNumber) {
            resultNumber = sum + grid[row][column]
        }
        return
    }
    helper(grid, row + 1, column, sum + grid[row][column])
    helper(grid, row, column + 1, sum + grid[row][column])
}

private fun minPathSum2(grid: Array<IntArray>): Int {
    val row = grid.size
    val column = grid[0].size
    val dp = Array(row) { IntArray(column) { -1 } }
    return bottomUp(grid, dp, row - 1, column - 1)
}

private fun bottomUp(grid: Array<IntArray>, dp: Array<IntArray>, row: Int, column: Int): Int {

    if (row < 0 || column < 0) return Int.MAX_VALUE
    if (row == 0 && column == 0) {
        return grid[row][column]
    }
    if (dp[row][column] != -1) return dp[row][column]
    return min(bottomUp(grid, dp, row - 1, column), bottomUp(grid, dp, row, column - 1)) + grid[row][column]
}

private fun minPathSum3(grid: Array<IntArray>): Int {
    for (row in grid.indices) {
        for (column in grid[0].indices) {
            if (row == 0 && column == 0) continue
            if (row == 0) {
                grid[row][column] += grid[row][column - 1]
            } else if (column == 0) {
                grid[row][column] += grid[row - 1][column]
            } else {
                grid[row][column] += min(grid[row - 1][column], grid[row][column-1])
            }
        }
    }
    for (array in grid) {
        println(array.joinToString())
    }
    return grid.last().last()
}
