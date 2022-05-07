package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val m = 4
    val n = 4
    val k = 4
    val matrix = Array(m) { i -> IntArray(n) { j -> i * n + j + 1 } }
    val result = shiftGrid(matrix, k)
    for (array in result) {
        println(array.joinToString())
    }
}

private fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
    val m = grid.size
    val n = grid[0].size
    if (m == 0 || n == 0) return emptyList()
    val shift = k % (m * n)
    val result = List(m) { MutableList(n) { 0 } }
    for (i in 0..grid.lastIndex) {
        for (j in 0..grid[0].lastIndex) {
            val temp = (shift + i * n + j) % (m * n)
            val row = temp / n
            val column = temp % n
            result[row][column] = grid[i][j]
        }
    }
    return result
}