package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

    println(
        maxEnvelopes(
            arrayOf(
                intArrayOf(3, 4),
                intArrayOf(5, 5),
                intArrayOf(5, 8),
                intArrayOf(9, 4),
            )
        )
    )

}

private fun maxEnvelopes(envelopes: Array<IntArray>): Int {
    envelopes.sortWith(compareBy<IntArray> { it.first() }.thenByDescending { it.last() })
    val dp = IntArray(envelopes.size)
    var length = 0
    for (item in envelopes) {
        var left = 0
        var right = length
        var middle = 0
        while (left < right) {
            middle = left + (right - left) / 2
            if (dp[middle] < item.last()) left = middle + 1
            else right = middle
        }
        dp[left] = item.last()
        if (left == length) length++

    }
    return length
}