package problems

import kotlin.concurrent.thread

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val matrix = Array(3) { i -> IntArray(4) { j -> i * 4 + j + 1 } }
    println(spiralOrder(matrix).joinToString())

}

private fun spiralOrder(matrix: Array<IntArray>): List<Int> {

    val list = mutableListOf<Int>()
    var bottom = matrix.lastIndex
    var right = matrix[0].lastIndex
    var left = 0
    var top = 0
    while (top <= bottom && left <= right) {
        for (i in left..right) {
            list.add(matrix[top][i])
        }
        top++
        for (i in top..bottom) {
            list.add(matrix[i][right])
        }
        right--
        if (top <= bottom) {
            for (i in right downTo left) {
                list.add(matrix[bottom][i])
            }
            bottom--
        }
        if (left <= right) {
            for (i in bottom downTo top) {
                list.add(matrix[i][left])
            }
            left++
        }
    }
    return list
}