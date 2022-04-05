package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var matrix = arrayOf(
        intArrayOf(1, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
    )
    println(uniquePathsWithObstacles(matrix))
    matrix = arrayOf(
        intArrayOf(0, 0),
        intArrayOf(1, 1),
        intArrayOf(0, 0),
    )
    println(uniquePathsWithObstacles(matrix))
}


private fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
    val m = obstacleGrid.size
    val n = obstacleGrid[0].size
    val matrix = Array(m) { IntArray(n) }
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (obstacleGrid[i][j] == 1) matrix[i][j] = -1
            else {
                if (i == 0 && j == 0) {
                    matrix[i][j] = 1
                } else if (i == 0) {
                    matrix[i][j] = if (matrix[i][j - 1] == -1) -1 else 1
                } else if (j == 0) {
                    matrix[i][j] = if (matrix[i - 1][j] == -1) -1 else 1
                } else {
                    matrix[i][j] = (if (matrix[i - 1][j] == -1) 0 else matrix[i - 1][j]) + (if (matrix[i][j - 1] == -1) 0 else matrix[i][j - 1])
                }
            }
        }
    }
    return if (matrix.last().last()==-1) 0 else matrix.last().last()
}

