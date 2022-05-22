package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(countSubstrings("aaa"))
    println(countSubstrings("abc"))
}

private var count = 0
private fun countSubstrings(s: String): Int {
    count = 0
    for (i in s.indices) {
        helper(s, i, i)
        helper(s, i, i + 1)
    }
    return count
}

private fun helper(s: String, left: Int, right: Int) {
    var l = left
    var r = right
    while (l >= 0 && r < s.length && s[l] == s[r]) {
        count++
        l--
        r++
    }
}