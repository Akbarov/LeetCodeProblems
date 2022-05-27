package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numTrees(3))
}

private fun numTrees(n: Int): Int {
    if (n <= 1) return 1
    val dp = IntArray(n+1)
    dp[0] =1
    dp[1] =1
    for (i in 2..n) {
        for (j in 1..i) {
            dp[i] += dp[j-1]*dp[i-j]
        }
    }
    return dp[n]
}