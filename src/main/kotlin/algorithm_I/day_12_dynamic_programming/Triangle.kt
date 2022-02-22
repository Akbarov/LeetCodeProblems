package algorithm_I.day_12_dynamic_programming

fun main() {
    println(minimumTotal(listOf(listOf(2))))
}

var minSum = Int.MAX_VALUE

private fun minimumTotal(triangle: List<List<Int>>): Int {
    sumValues(triangle, 0, 0, 0)
    return minSum
}

private fun sumValues(list: List<List<Int>>, row: Int, column: Int, sum: Int) {
    if (row >= list.size) {
        return
    } else if (row == list.lastIndex) {
        val inner = list[row]
        if (inner.lastIndex >= column && inner[column] + sum < minSum) {
            minSum = inner[column] + sum
        }
    } else {
        sumValues(list, row + 1, column, list[row][column] + sum)
        sumValues(list, row + 1, column + 1, list[row][column] + sum)
    }
}