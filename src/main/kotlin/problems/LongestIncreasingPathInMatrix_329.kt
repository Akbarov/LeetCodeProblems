import kotlin.math.max

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        longestIncreasingPath(
            arrayOf(
                intArrayOf(3, 4, 5),
                intArrayOf(3, 2, 6),
                intArrayOf(2, 2, 1),
            )
        )
    )
    println(
        longestIncreasingPath(
            arrayOf(
                intArrayOf(1)
            )
        )
    )
}

private fun longestIncreasingPath(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
    var result = 0
    val memo = Array(matrix.size) { IntArray(matrix[0].size) }
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            val temp = bfs(matrix, memo, -1, i, j)
            result = max(temp, result)
        }
    }
    for (a in memo) {
        println(a.joinToString())
    }
    return result
}

private fun bfs(matrix: Array<IntArray>, memo: Array<IntArray>, prev: Int, i: Int, j: Int): Int {
    if (i < 0 || j < 0 || i >= matrix.size || j >= matrix[0].size) return 0
    if (prev >= matrix[i][j]) return 0
    if (memo[i][j] != 0) return memo[i][j]
    val top = bfs(matrix, memo, matrix[i][j], i - 1, j)
    val bottom = bfs(matrix, memo, matrix[i][j], i + 1, j)
    val left = bfs(matrix, memo, matrix[i][j], i, j - 1)
    val right = bfs(matrix, memo, matrix[i][j], i, j + 1)
    memo[i][j] = max(max(top, bottom), max(left, right))+1
    return memo[i][j]
}