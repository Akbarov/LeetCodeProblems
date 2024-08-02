package uber

import kotlin.math.max


fun main() {

}

private fun maxKilledEnemies(grid: Array<CharArray>): Int {
    var result = 0
    var rowCount = 0
    val colCount = IntArray(grid[0].size)
    for (i in grid.indices) {
        for (j in grid[i].indices) {
            if (j == 0 || grid[i][j - 1] == 'W') {
                rowCount = 0
                for (k in j until grid[i].size) {
                    if (grid[i][k] == 'E') rowCount++
                    else if (grid[i][k] == 'W') break
                }
            }
            if (i == 0 || grid[i - 1][j] == 'W') {
                colCount[j] = 0
                for (k in i until grid.size) {
                    if (grid[k][j] == 'E') colCount[j]++
                    else if (grid[k][j] == 'W') break
                }
            }
            if (grid[i][j] == '0') result = max(result, rowCount + colCount[j])
        }
    }
    return result
}
