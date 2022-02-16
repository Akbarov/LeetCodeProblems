package problems

fun main() {
  println(longestPalindrome("babad"))
  println(longestPalindrome("abbcc"))
}

private fun longestPalindrome(s: String): String {
    var result = ""
    var length = 0
    for (i in s.indices) {
        var left = i
        var right = i
        while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
            if (right - left + 1 > length) {
                length = right - left + 1
                result = s.substring(left, right + 1)
            }
            left--
            right++
        }
        left = i
        right = i + 1
        while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
            if (right - left + 1 > length) {
                length = right - left + 1
                result = s.substring(left, right + 1)
            }
            left--
            right++
        }
    }
    return result
}