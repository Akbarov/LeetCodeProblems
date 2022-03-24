package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        islandPerimeter(
            arrayOf(
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 1, 0),
                intArrayOf(0, 1, 0, 0),
                intArrayOf(1, 1, 0, 0)
            )
        )
    )
}


private fun islandPerimeter(grid: Array<IntArray>): Int {
    var p = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == 1) {
                p += 4
                if (i > 0 && grid[i - 1][j] == 1) {
                    p -= 2
                }
                if (j > 0 && grid[i][j - 1] == 1) {
                    p -= 2
                }
            }
        }
    }
    return p
}
