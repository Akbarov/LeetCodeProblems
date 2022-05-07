package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
        val matrix = generateMatrix(6)
    for (array in matrix) {
        println(array.joinToString())
    }
}

private fun generateMatrix(n: Int): Array<IntArray> {
    if (n <= 0) return emptyArray()
    val matrix = Array(n) { IntArray(n) }
    var count = 1
    for (i in 0 until n) {
        for (j in i until n - i) {
            matrix[i][j] = count++
        }
        for (k in i + 1 until n - i) {
            matrix[k][n - 1 - i] = count++
        }
        for (t in n - 2 - i downTo i) {
            matrix[n - 1 - i][t] = count++
        }
        for (z in n - 2 - i downTo i+1) {
            matrix[z][i] = count++
        }
    }
    return matrix
}