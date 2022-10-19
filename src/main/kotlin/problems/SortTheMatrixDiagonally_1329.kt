package problems

import kotlin.random.Random

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var mat = Array(3) { i -> IntArray(4) { Random.nextInt(1, 20) } }
    mat.forEach {
        println(it.joinToString())
    }
    mat = diagonalSort(mat)
    mat.forEach {
        println(it.joinToString())
    }

}

private fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    for (row in mat.indices) {
        val list = mutableListOf<Int>()
        var column = 0
        while (column < n && row + column < m) {
            list.add(mat[row + column][column])
            column++
        }
        list.sort()
        column = 0
        while (column < n && row + column < m) {
            mat[row + column][column] = list[column]
            column++
        }
    }
    for (column in 1 until n) {
        val list = mutableListOf<Int>()
        var row = 0
        while (row < m && row + column < n) {
            list.add(mat[row][column + row])
            row++
        }
        list.sort()
        row = 0
        while (row < m && row + column < n) {
            mat[row][column + row] = list[row]
            row++
        }
    }

    return mat
}