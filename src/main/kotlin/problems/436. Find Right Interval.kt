package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun findRightInterval(intervals: Array<IntArray>): IntArray {
    val dp = Array<IntArray>(intervals.size) { intArrayOf() }
    for ((index, r) in intervals.withIndex()) {
        dp[index] = intArrayOf(r[0], r[1], index)
    }
    dp.sortBy { it.first() }
    val result = IntArray(intervals.size) { -1 }
    for ((i, row) in dp.withIndex()) {
        if (row[1] == row[0]) {
            result[row[2]] = row[2]
            continue
        }
        var left = i + 1
        var right = dp.lastIndex
        var next = -1
        while (left <= right) {
            val mid = (left + right) / 2
            if (dp[mid][0] >= row[1]) {
                next = dp[mid][2]
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        result[row[2]] = next
    }
    return result
}