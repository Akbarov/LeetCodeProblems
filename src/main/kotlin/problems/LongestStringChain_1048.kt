package problems


/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(longestStrChain(arrayOf("a", "b", "ba", "bca", "bda", "bdca")))
}

private fun longestStrChain(words: Array<String>): Int {
    words.sortBy { it.length }
    val dp = mutableMapOf<String, Int>()
    var result = 0
    for (word in words) {
        var len = 0
        for (i in word.indices) {
            val prev = word.substring(0, i) + word.substring(i+1)
            len = len.coerceAtLeast((dp[prev] ?: 0) + 1)
        }
        dp[word] = len
        result = len.coerceAtLeast(result)
    }
    return result
}