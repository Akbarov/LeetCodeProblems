package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(countGoodSubstrings("aababcabc"))
}

private fun countGoodSubstrings(s: String): Int {
    var count = 0
    for (i in 0 until s.length - 2) {
        if (s[i] != s[i + 1] && s[i + 1] != s[i + 2] && s[i] != s[i + 2]) count++
    }
    return count
}