package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 1, 4)
    matrixReshape(arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)), 4, 1)
}

private fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val result = Array(r) { IntArray(c) }
    for (i in mat.indices) {
        for (j in mat[i].indices) {
            val temp = i * mat[0].size + j
            result[temp / c][temp % c] = mat[i][j]
        }
    }
    return result
}