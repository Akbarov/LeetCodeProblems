package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        findBall(
            arrayOf(
                intArrayOf(1)
            )
        ).joinToString()
    )
}

private fun findBall(grid: Array<IntArray>): IntArray {
    val m = grid.size
    val n = grid[0].size
    val result = IntArray(n)
    for (column in 0 until n) {
        var j = column
        outer@ for (i in 0 until m) {
            if (j == 0 && grid[i][j] == -1) {
                j = -1
                break@outer
            }
            if (j == n - 1 && grid[i][j] == 1) {
                j = -1
                break@outer
            }

            if (grid[i][j] == 1) {
                if (j < n - 1 && grid[i][j + 1] == -1) {
                    j = -1
                    break@outer
                } else {
                    j++
                }
            } else {
                if (j > 0 && grid[i][j - 1] == 1) {
                    j = -1
                    break@outer
                } else {
                    j--
                }
            }
        }
        result[column] = j

    }
    return result
}