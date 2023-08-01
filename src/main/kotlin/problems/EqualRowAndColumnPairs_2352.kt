package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun equalPairs(grid: Array<IntArray>): Int {
    val colStrings = Array(grid.size) { "" }
    var result = 0
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            colStrings[j] = colStrings[j] + "," + grid[i][j]
        }
    }
    for (array in grid) {
        val row = "," + array.joinToString(",")
        for (col in colStrings) {
            if (col == row) result++
        }
    }
    return result
}

private var count = 0
private fun equalPairs2(grid: Array<IntArray>): Int {
    count = 0
    for (i in grid.indices) {
        for (j in grid.indices) {
            dfs(grid,i,0,0,j)
        }
    }
    return count
}

private fun dfs(grid: Array<IntArray>, r1: Int, c1: Int, r2: Int, c2: Int) {
    if (grid[r1][c1] != grid[r2][c2]) return
    if (c1 == grid.lastIndex && r2 == grid.lastIndex) {
        count++
        return
    }
    dfs(grid, r1, c1 + 1, r2 + 1, c2)
}