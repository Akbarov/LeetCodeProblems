package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(uniquePaths2(51, 9))
}

private fun uniquePaths(m: Int, n: Int): Int {
    if (m < 1 || n < 1) return 0
    if (m == 1 && n == 1) {
        return 1
    }
    return uniquePaths(m - 1, n) + uniquePaths(m, n - 1)
}

private fun uniquePaths2(m: Int, n: Int): Int {
    val matrix = Array(m) { IntArray(n) }
    for (i in 0 until m) {
        for (j in 0 until n) {
            if (i == 0 || j == 0) matrix[i][j] = 1
            else{
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j-1]
            }
        }
    }
    return matrix.last().last()
}

