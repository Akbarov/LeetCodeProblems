package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(numDecodings("12"))
    println(numDecodings("226"))
    println(numDecodings("0"))
    println(numDecodings("111111111111111111111111111111111111111111111"))
}

private fun numDecodings(s: String, index: Int=0): Int {
    if (index >= s.length) return 1
    val first = s[index] - '0'
    if (first == 0) return 0
    val count1 = numDecodings(s, index + 1)
    var count2 = 0
    if (first <= 2) {
        if (index < s.lastIndex) {
            val second = s[index + 1] - '0'
            if (first * 10 + second <= 26) {
                count2 = numDecodings(s, index + 2)
            }
        }
    }
    return count1 + count2
}

private fun numDecodings(s: String): Int {
    val dp = IntArray(s.length + 1)
    dp[0] = 1
    dp[1] = if (s[0] == '0') 0 else 1
    for (i in 2..s.length) {
        val first = s[i - 1] - '0'
        val second = s[i - 2] - '0'
        if (first in 1..9) {
            dp[i] += dp[i - 1]
        }
        if (second * 10 + first in 10..26) {
            dp[i] += dp[i - 2]
        }
    }
    return dp.last()
}