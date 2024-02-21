package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {

}

private fun minTaps(n: Int, ranges: IntArray): Int {
    val dp = IntArray(n + 1) { Int.MAX_VALUE }

    for ((i, elem) in ranges.withIndex()) {
        val start = Math.max(i - elem, 0)
        val end = Math.min(n, i + elem)
        for (j in start..end) {
            dp[j] = Math.min(dp[j], dp[start] + 1)
        }
    }


    return if (dp[n] == Int.MAX_VALUE) -1 else dp[n]
}