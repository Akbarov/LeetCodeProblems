package problems

/**
Creator: Zohidjon Akbarov
 */
fun main() {
println(reverseVowels("hello"))
println(reverseVowels("leetcode"))
}

private fun reverseVowels(s: String): String {
    if (s.isEmpty())return s
    var left = 0
    var right = s.lastIndex
    val result = s.toCharArray()
    val set = setOf('a', 'A', 'e', 'E', 'u', 'U', 'i', 'I', 'o', 'O')
    while (left < right) {
        if (result[left] in set) {
            if (result[right] in set) {
                val temp = result[left]
                result[left] = result[right]
                result[right] = temp
                left++
                right--
            } else {
                right--
            }
        } else {
            left++
        }
    }
    return result.joinToString("")
}