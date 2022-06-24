package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(validPalindrome("aba"))
    println(validPalindrome("ababaa"))
}

private fun validPalindrome(s: String): Boolean {
    var l = 0
    var r = s.lastIndex
    while (l < r) {
        if (s[l] != s[r]) {
            return isPalindrome(s, l + 1, r) || isPalindrome(s, l, r - 1)
        }
        l++
        r--
    }
    return true
}

private fun isPalindrome(s: String, left: Int, right: Int): Boolean {
    var l = left
    var r = right
    while (l < r) {
        if (s[l] != s[r]) return false
        l++
        r--
    }
    return true
}