package problems

fun main() {

}

private fun minimumLength(s: String): Int {
    var left = 0
    var right = s.lastIndex
    while (left < right && s[left] == s[right]) {
        val startChar = s[left]
        while (left < right && s[left] == s[right]) {
            left++
        }
        while (left < right && startChar == s[right]) {
            right--
        }
    }
    return right - left + 1
}