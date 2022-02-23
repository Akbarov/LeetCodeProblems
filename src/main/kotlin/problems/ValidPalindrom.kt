package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(isPalindrome("A man, a plan, a canal: Panama"))
println(isPalindrome("race a car"))
println(isPalindrome(" "))
}

private fun isPalindrome(s: String): Boolean {

    if (s.isBlank()) return true

    var left = 0
    var right = s.lastIndex
    while (left <= right) {
        while (left <= right && !s[left].isLetterOrDigit()) left++
        while (left <= right && !s[right].isLetterOrDigit()) right--
        if (!s[left].equals(s[right], true)) return false
        left++
        right--
    }
    return true
}