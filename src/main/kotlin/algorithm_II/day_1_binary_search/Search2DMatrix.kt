package algorithm_II.day_1_binary_search

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(
        searchMatrix(
            arrayOf(
                intArrayOf(1, 2, 3, 5),
                intArrayOf(10, 11, 13, 15),
                intArrayOf(20, 30, 40, 45)
            ), 3
        )
    )
    println(
        searchMatrix(
            arrayOf(
                intArrayOf(1, 2, 3, 5),
                intArrayOf(10, 11, 13, 15),
                intArrayOf(20, 30, 40, 45)
            ), 14
        )
    )
    println(searchMatrix(arrayOf(intArrayOf(2)), 2))
}

private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    var top = matrix.size
    var down = 0
    var row = 0
    while (down < top) {
        val mid = (top + down) / 2
        if (mid >= matrix.size) break
        if (matrix[mid][0] > target) {
            top = mid - 1
        } else if (matrix[mid][0] < target) {
            if (matrix[mid].last() >= target) {
                row = mid
                break
            } else {
                down = mid + 1
            }
        } else {
            return true
        }
    }
    var left = 0
    var right = matrix[row].size
    while (left < right) {
        val mid = left + (right - left) / 2
        if (mid >= matrix[0].size) break
        if (matrix[row][mid] < target) {
            left = mid + 1
        } else if (matrix[row][mid] > target) {
            right = mid - 1
        } else {
            return true
        }
    }

    return false
}
