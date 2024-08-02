package uber

import java.util.LinkedList
import java.util.Queue

fun main() {

}

private fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
    val result = Array(mat.size) { IntArray(mat[0].size) { Int.MAX_VALUE } }
    for (i in mat.indices) {
        for (j in mat[i].indices) {
            if (mat[i][j] == 0) {
                result[i][j] = 0
            }
        }
    }
    for (i in mat.indices) {
        for (j in mat[i].indices) {
            if (mat[i][j] == 0) {
                result[i][j] = 0
                recalculate(mat, i, j, result)
            }
        }
    }
    return result
}

private fun recalculate(mat: Array<IntArray>, i: Int, j: Int, result: Array<IntArray>) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    val adj = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
    queue.add(Pair(i, j))
    val set = mutableSetOf<Pair<Int, Int>>()
    set.add(Pair(i, j))
    var count = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val (row, col) = queue.poll()
            result[row][col] = count
            for (point in adj) {
                val nextRow = row + point.first()
                val nextCol = col + point.last()
                if (nextRow in mat.indices && nextCol in mat[i].indices && result[nextRow][nextCol] > count) {
                    val next = Pair(nextRow, nextCol)
                    if (next !in set) {
                        queue.add(next)
                    }
                }
            }
        }
        count++
    }
}

