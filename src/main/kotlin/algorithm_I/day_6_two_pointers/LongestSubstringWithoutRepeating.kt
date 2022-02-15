package algorithm_I.day_6_two_pointers

/**
Creator: Zohidjon Akbarov
 */
fun main() {
    println(lengthOfLongestSubstring("abcabcbb"))
}

private fun lengthOfLongestSubstring(s: String): Int {
    var result = ""
    var maxLength = 0
    for (c in s) {
        if (result.contains(c)) {
            if (maxLength < result.length) maxLength = result.length
            result = result.substringAfter(c)
        }
        result += c

    }
    return if(maxLength>result.length)maxLength else result.length
}