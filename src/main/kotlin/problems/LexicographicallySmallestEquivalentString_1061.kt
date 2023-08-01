package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(smallestEquivalentString("parker", "morris", "parser"))
}

private fun smallestEquivalentString(s1: String, s2: String, baseStr: String): String {
    val dp = IntArray(26) { it }
    for (i in s1.indices) {
        var a = find(dp, s1[i] - 'a')
        var b = find(dp, s2[i] - 'a')
        if (a > b) {
            dp[a] = b
        } else {
            dp[b] = a
        }
    }
    val sb = StringBuilder()
    for (c in baseStr) {
        sb.append('a' + find(dp, c - 'a'))
    }
    return sb.toString()
}

private fun find(dp: IntArray, index: Int): Int {
    var j = index
    while (j != dp[j]) {
        j = dp[j]
    }
    return j
}