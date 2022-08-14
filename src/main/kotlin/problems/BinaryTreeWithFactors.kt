package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numFactoredBinaryTrees(intArrayOf(2,4)))
}

private fun numFactoredBinaryTrees(arr: IntArray): Int {
    val mod = 1_000_000_007
    arr.sort()
    val dp = LongArray(arr.size) { 1L }
    val index = mutableMapOf<Int, Int>()
    for (i in arr.indices) {
        index[arr[i]] = i
    }
    for (i in arr.indices) {
        for (j in 0 until i) {
            if (arr[i] % arr[j] == 0) {
                val right = arr[i] / arr[j]
                val k = index[right]
                k?.apply {
                    dp[i] = (dp[i] + dp[j] * dp[this]) % mod
                }
            }
        }
    }
    var ans = 0L
    for (x in dp) {
        ans += x
    }
    return (ans % mod).toInt()
}