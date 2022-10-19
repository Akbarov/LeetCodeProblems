package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    rotate(Array(4) { i -> IntArray(4) { j -> i * 4 + j + 1 } })
}

private fun rotate(matrix: Array<IntArray>) {
    val n = matrix.size
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    for (i in 0 until n ) {
        for (j in 0 until n/2) {
            val temp = matrix[i][j]
            matrix[i][j] = matrix[i][n-1-j]
            matrix[i][n-1-j] = temp
        }
    }
    for (array in matrix) {
        println(array.joinToString())
    }
}