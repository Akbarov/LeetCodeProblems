package algorithm_II.day_6_breadth_first_search

/**
Creator: Zohidjon Akbarov
 */
fun main() {
val grid = arrayOf(charArrayOf('1','1','1'),charArrayOf('0','1','0'),charArrayOf('1','1','1'),)
    println(numIslands(grid))
}

private fun numIslands(grid: Array<CharArray>): Int {

    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    val isVisited = Array(grid.size) { BooleanArray(grid.first().size) }
    var count = 0
    for ((i, array) in grid.withIndex()) {
        for ((j, value) in array.withIndex()) {
            if (!isVisited[i][j] && value == '1') {
                bfs(grid, i, j, isVisited)
                count++
            }
        }
    }
    return count
}

private fun bfs(grid: Array<CharArray>, i: Int, j: Int, isVisited: Array<BooleanArray>) {
    if (i < 0 || j < 0 || i >= grid.size || j >= grid[0].size || isVisited[i][j]) return
    isVisited[i][j] = true
    if (grid[i][j] == '1') {
        bfs(grid, i, j + 1, isVisited)
        bfs(grid, i, j - 1, isVisited)
        bfs(grid, i - 1, j, isVisited)
        bfs(grid, i + 1, j, isVisited)
    }

}