package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    setZeroes2(
        arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1),
        )
    )
    setZeroes2(
        arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(1, 1, 1, 9),
            intArrayOf(1, 4, 1, 1),
        )
    )

}

private fun setZeroes(matrix: Array<IntArray>) {
    val zeroColumn = BooleanArray(matrix[0].size)
    val zeroRow = BooleanArray(matrix.size)
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) {
                zeroColumn[j] = true
                zeroRow[i] = true
            }
        }
    }
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (zeroRow[i]) {
                matrix[i][j] = 0
            } else if (zeroColumn[j]) {
                matrix[i][j] = 0
            }
        }
    }
    for (a in matrix) {
        println(a.joinToString())
    }
}

private fun setZeroes2(matrix: Array<IntArray>) {
    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) {
                matrix[i][0] = 0
                matrix[0][j] = 0
            }
        }
    }
    for (i in matrix.lastIndex downTo 0) {
        for (j in matrix[0].lastIndex downTo 0) {
            if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                matrix[i][j] = 0
            }
        }
    }
    for (a in matrix) {
        println(a.joinToString())
    }
}