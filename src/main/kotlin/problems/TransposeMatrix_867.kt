package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    var matrix = Array(2) { i -> IntArray(3) { j -> i * 3 + j + 1 } }
    matrix = transpose(matrix)
    for (a in matrix) {
        println(a.joinToString())
    }
}

private fun transpose(matrix: Array<IntArray>): Array<IntArray> {
    val n = matrix.size
    val m = matrix[0].size
    val result = Array(m) { IntArray(n) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            result[j][i] = matrix[i][j]
        }
    }
    return result
}