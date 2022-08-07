package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countVowelPermutation2(1))
    println(countVowelPermutation2(2))
    println(countVowelPermutation2(100))
}

private var count = 0
private val mode = 100_000_000+7

private fun countVowelPermutation2(n: Int): Int {
    count = 0
    if (n <= 0) return 0
    if (n == 1) return 5
    val dp = Array(n) { IntArray(5) }
    dp[0][0] = 1
    dp[0][1] = 1
    dp[0][2] = 1
    dp[0][3] = 1
    dp[0][4] = 1
    for (i in 1 until n) {
        dp[i][0] = (dp[i][1] + dp[i][2] + dp[i][4]) % mode
        dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mode
        dp[i][2] = ( dp[i-1][1] + dp[i-1][3]) % mode
        dp[i][3] = (dp[i-1][2])
        dp[i][4] = (dp[i-1][2]+dp[i-1][3])% mode

    }
    val array = dp[n - 1]
    for (item in array) {
        count = (item + count)% mode
    }
    return count
}


private fun countVowelPermutation(n: Int): Int {
    arrayOf("a", "e", "u", "i", "o").forEach {
        helper(n, it)
    }
    return count
}

private fun helper(n: Int, permutation: String) {
    if (permutation.length == n) {
        count++
        count %= mode
        return
    }
    if (permutation.length > n) return
    when (permutation.first()) {
        'a' -> {
            helper(n, "i$permutation")
            helper(n, "e$permutation")
            helper(n, "u$permutation")
        }
        'e' -> {
            helper(n, "a$permutation")
            helper(n, "i$permutation")
        }
        'i' -> {
            helper(n, "e$permutation")
            helper(n, "o$permutation")
        }
        'o' -> {
            helper(n, "i$permutation")
        }
        'u' -> {
            helper(n, "i$permutation")
            helper(n, "o$permutation")
        }
    }
}