package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(isSubsequence("abc","ahbgdc"))
println(isSubsequence("axc","ahbgdc"))
}

private fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty())return true
    var count = 0
    for (c in t) {
        if (c == s[count]) {
            count++
            if (count == s.length) {
                return true
            }
        }

    }
    return false
}