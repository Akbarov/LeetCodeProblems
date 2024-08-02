package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        numberOfSubmatrices(
            arrayOf(
                charArrayOf('.', '.'),
                charArrayOf('Y', 'X'),
            )
        )
    )
}

private fun numberOfSubmatrices(grid: Array<CharArray>): Int {
    var result = 0
    val xArray = getGridCount(grid,'X')
    val yArray = getGridCount(grid,'X')
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (xArray[i][j] > 0 && xArray[i][j] == yArray[i][j]) {
                result++
            }
        }
    }
    return result
}

private fun getGridCount(grid: Array<CharArray>, c: Char): Array<IntArray> {
    val result = Array(grid.size) { IntArray(grid[0].size) }
    for (i in result.indices) {
        for (j in result[0].indices) {
            if (grid[i][j] == c) result[i][j]++
            if (i > 0) result[i][j] += result[i - 1][j]
            if (j > 0) result[i][j] += result[i][j - 1]
            if (i > 0 && j > 0) result[i][j] -= result[i - 1][j - 1]
        }
    }
    return result
}