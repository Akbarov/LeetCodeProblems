package problems

import kotlin.math.min

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var result = updateMatrix(
        arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 0),
        )
    )
    for (a in result) {
        println(a.joinToString())
    }
    result = updateMatrix(
        arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(1, 1, 1),
        )
    )
    for (a in result) {
        println(a.joinToString())
    }
}

private fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    if (mat.isEmpty() || mat[0].isEmpty()) return mat
    val r = mat.size
    val c = mat[0].size
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (mat[i][j] == 0) continue
            val left = if (j > 0) mat[i][j - 1] else r + c
            val top = if (i > 0) mat[i - 1][j] else r + c
            mat[i][j] = min(left, top) + 1
        }
    }
    for (i in r - 1 downTo 0) {
        for (j in c - 1 downTo 0) {
            if (mat[i][j] == 0) continue
            val right = if (j < c - 1) mat[i][j + 1] else r + c
            val top = if (i < r - 1) mat[i + 1][j] else r + c
            mat[i][j] = min(mat[i][j], min(right, top) + 1)
        }
    }
    return mat
}