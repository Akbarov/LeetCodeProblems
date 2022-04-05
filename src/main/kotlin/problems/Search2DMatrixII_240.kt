package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    val matrix = Array(5) { i -> IntArray(5) { j -> i * 5 + j } }
    println(searchMatrix(matrix, 10))
    println(searchMatrix(matrix, 26))
}

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    for (array in matrix) {
        var l = 0
        var r = array.lastIndex
        if (array[l] > target) return false
        while (l <= r) {
            val mid = (l + r) / 2
            if (array[mid] == target) {
                return true
            } else if (array[mid] > target) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
    }
    return false
}

private fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    var row = 0
    var col = matrix[0].lastIndex
    while (row <= matrix.lastIndex && col >= 0) {
        if (matrix[row][col] == target) return true
        else if (matrix[row][col] > target) col--
        else row++
    }
    return false
}